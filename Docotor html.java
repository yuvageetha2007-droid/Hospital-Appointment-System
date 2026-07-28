<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Doctors — PulseCare</title>
<style>
  *{ box-sizing: border-box; }
  body{
    margin: 0;
    font-family: 'Segoe UI', Arial, sans-serif;
    background: #EEF1ED;
    color: #1F2E2B;
  }
  .topbar{
    background: #2C5A4D;
    color: #fff;
    padding: 22px 30px;
    font-size: 22px;
    font-weight: 600;
  }
  .wrap{
    max-width: 900px;
    margin: 40px auto;
    padding: 0 20px;
    display: grid;
    grid-template-columns: 1fr 1.2fr;
    gap: 20px;
  }
  .panel{
    background: #fff;
    border: 1px solid #D8DED9;
    border-radius: 14px;
    padding: 26px;
    position: relative;
  }
  h2{ margin-top: 0; font-size: 19px; }
  label{
    display: block;
    font-size: 13px;
    font-weight: 600;
    color: #5B6B63;
    margin: 14px 0 6px;
  }
  input{
    width: 100%;
    padding: 12px 14px;
    border: 1px solid #D8DED9;
    border-radius: 8px;
    font-size: 14px;
  }
  input:focus{
    outline: none;
    border-color: #3E7C6B;
  }
  button{
    width: 100%;
    margin-top: 22px;
    padding: 14px;
    background: #2C5A4D;
    color: #fff;
    border: none;
    border-radius: 8px;
    font-size: 15px;
    font-weight: 600;
    cursor: pointer;
  }
  button:hover{ background: #3E7C6B; }

  /* ---- Success note (toast) ---- */
  #successNote{
    display: none;
    align-items: center;
    gap: 10px;
    background: #EAF2EF;
    border: 1px solid #BFE0D4;
    color: #2C5A4D;
    font-size: 14px;
    font-weight: 600;
    padding: 14px 16px;
    border-radius: 10px;
    margin-bottom: 16px;
    animation: slideIn .3s ease-out;
  }
  #successNote .tick{
    width: 20px; height: 20px;
    border-radius: 50%;
    background: #3E7C6B;
    color: #fff;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 13px;
    flex-shrink: 0;
  }
  @keyframes slideIn{
    from{ opacity: 0; transform: translateY(-8px); }
    to{ opacity: 1; transform: translateY(0); }
  }
  @media (prefers-reduced-motion: reduce){
    #successNote{ animation: none; }
  }

  /* ---- Doctor list ---- */
  .doctor{
    display: flex;
    align-items: center;
    gap: 14px;
    padding: 12px 0;
    border-top: 1px solid #D8DED9;
  }
  .doctor:first-of-type{ border-top: none; padding-top: 0; }
  .doctor__avatar{
    width: 42px; height: 42px;
    border-radius: 50%;
    background: linear-gradient(135deg, #3E7C6B, #2C5A4D);
    color: #fff;
    display: flex; align-items: center; justify-content: center;
    font-weight: 700;
    font-size: 15px;
    flex-shrink: 0;
  }
  .doctor h3{ font-size: 14.5px; font-weight: 700; margin: 0 0 2px; }
  .doctor p{ font-size: 12.5px; color: #5B6B63; margin: 0; }

  @media (max-width: 780px){
    .wrap{ grid-template-columns: 1fr; }
  }
</style>
</head>
<body>

  <div class="topbar">Doctors</div>

  <div class="wrap">

    <div class="panel">
      <div id="successNote">
        <span class="tick">✓</span>
        <span>Doctor added successfully!</span>
      </div>

      <h2>Add Doctor</h2>

      <form id="doctorForm" onsubmit="return showSuccess(event)">
        <label for="doctorName">Doctor Name</label>
        <input type="text" id="doctorName" name="doctorName" required>

        <label for="specialization">Specialization</label>
        <input type="text" id="specialization" name="specialization" required>

        <label for="phone">Phone</label>
        <input type="tel" id="phone" name="phone" required>

        <label for="email">Email</label>
        <input type="email" id="email" name="email" required>

        <button type="submit">Add Doctor</button>
      </form>
    </div>

    <div class="panel">
      <h2>Our Doctors</h2>

      <div id="doctorList">
        <div class="doctor">
          <div class="doctor__avatar">AK</div>
          <div>
            <h3>Dr. Arun Kumar</h3>
            <p>Cardiology</p>
          </div>
        </div>
        <div class="doctor">
          <div class="doctor__avatar">MR</div>
          <div>
            <h3>Dr. Meena Rao</h3>
            <p>General Physician</p>
          </div>
        </div>
        <div class="doctor">
          <div class="doctor__avatar">SB</div>
          <div>
            <h3>Dr. Suresh Babu</h3>
            <p>Orthopedic</p>
          </div>
        </div>
      </div>
    </div>

  </div>

  <script>
    function showSuccess(event) {
      event.preventDefault(); // stop page reload so the note stays visible

      var name = document.getElementById("doctorName").value.trim();
      var specialization = document.getElementById("specialization").value.trim();

      // add the new doctor straight to the list on this page
      if (name && specialization) {
        var initials = name.replace("Dr.", "").trim().split(" ")
          .map(function (w) { return w[0]; })
          .join("")
          .substring(0, 2)
          .toUpperCase();

        var doctorList = document.getElementById("doctorList");
        var row = document.createElement("div");
        row.className = "doctor";
        row.innerHTML =
          '<div class="doctor__avatar">' + initials + '</div>' +
          '<div><h3>' + name + '</h3><p>' + specialization + '</p></div>';
        doctorList.prepend(row);
      }

      var note = document.getElementById("successNote");
      note.style.display = "flex";

      document.getElementById("doctorForm").reset();

      note.scrollIntoView({ behavior: "smooth", block: "start" });

      clearTimeout(window.__noteTimer);
      window.__noteTimer = setTimeout(function () {
        note.style.display = "none";
      }, 4000);

      // to actually save this doctor to your Java backend later,
      // this is where you would call fetch(...) with the form fields
      return false;
    }
  </script>

</body>
</html>
