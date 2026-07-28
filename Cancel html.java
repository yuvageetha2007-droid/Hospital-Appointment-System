<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cancel Appointment — PulseCare</title>
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
    max-width: 460px;
    margin: 40px auto;
    background: #fff;
    border-radius: 14px;
    padding: 30px;
    border: 1px solid #D8DED9;
    position: relative;
  }
  h2{ margin-top: 0; }
  label{
    display: block;
    font-size: 13px;
    font-weight: 600;
    color: #5B6B63;
    margin: 16px 0 6px;
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
    margin-top: 24px;
    padding: 14px;
    background: #C4563F;
    color: #fff;
    border: none;
    border-radius: 8px;
    font-size: 15px;
    font-weight: 600;
    cursor: pointer;
  }
  button:hover{ background: #A8452F; }

  /* ---- Success note (toast) ---- */
  #successNote{
    display: none;
    align-items: center;
    gap: 10px;
    background: #FBEDEA;
    border: 1px solid #EBC3B8;
    color: #A8452F;
    font-size: 14px;
    font-weight: 600;
    padding: 14px 16px;
    border-radius: 10px;
    margin-bottom: 18px;
    animation: slideIn .3s ease-out;
  }
  #successNote .tick{
    width: 20px; height: 20px;
    border-radius: 50%;
    background: #C4563F;
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
</style>
</head>
<body>

  <div class="topbar">Cancel Appointment</div>

  <div class="wrap">

    <div id="successNote">
      <span class="tick">✓</span>
      <span>Sorry, your appointment was successfully cancelled.</span>
    </div>

    <h2>Cancel Appointment</h2>

    <form id="cancelForm" onsubmit="return showSuccess(event)">
      <label for="patientName">Patient Name</label>
      <input type="text" id="patientName" name="patientName" required>

      <label for="apptId">Appointment ID</label>
      <input type="text" id="apptId" name="apptId" required>

      <button type="submit">Cancel Appointment</button>
    </form>
  </div>

  <script>
    function showSuccess(event) {
      event.preventDefault(); // stop page reload so the note stays visible

      var note = document.getElementById("successNote");
      note.style.display = "flex";

      document.getElementById("cancelForm").reset();

      note.scrollIntoView({ behavior: "smooth", block: "start" });

      clearTimeout(window.__noteTimer);
      window.__noteTimer = setTimeout(function () {
        note.style.display = "none";
      }, 4000);

      // to actually cancel this appointment in your Java backend later,
      // this is where you would call fetch(...) with the appointment ID
      return false;
    }
  </script>

</body>
</html>
