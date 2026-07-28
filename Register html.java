<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register — PulseCare</title>
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
  input, select{
    width: 100%;
    padding: 12px 14px;
    border: 1px solid #D8DED9;
    border-radius: 8px;
    font-size: 14px;
    font-family: inherit;
  }
  input:focus, select:focus{
    outline: none;
    border-color: #3E7C6B;
  }
  button{
    width: 100%;
    margin-top: 24px;
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

  .foot{
    text-align: center;
    font-size: 13px;
    color: #5B6B63;
    margin-top: 18px;
  }
  .foot a{ color: #2C5A4D; font-weight: 600; text-decoration: none; }
  .foot a:hover{ text-decoration: underline; }

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
    margin-bottom: 18px;
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
</style>
</head>
<body>

  <div class="topbar">PulseCare</div>

  <div class="wrap">

    <div id="successNote">
      <span class="tick">✓</span>
      <span>Patient registered successfully!</span>
    </div>

    <h2>Patient Register</h2>

    <form id="registerForm" onsubmit="return showSuccess(event)">
      <label for="name">Full Name</label>
      <input type="text" id="name" name="name" required>

      <label for="age">Age</label>
      <input type="number" id="age" name="age" min="0" required>

      <label for="gender">Gender</label>
      <select id="gender" name="gender" required>
        <option value="" disabled selected>Select gender</option>
        <option value="Male">Male</option>
        <option value="Female">Female</option>
        <option value="Other">Other</option>
      </select>

      <label for="phone">Phone</label>
      <input type="tel" id="phone" name="phone" required>

      <label for="email">Email</label>
      <input type="email" id="email" name="email" required>

      <label for="password">Password</label>
      <input type="password" id="password" name="password" required>

      <button type="submit">Register</button>
    </form>

    <p class="foot">Already have an account? <a href="login.html">Login here</a></p>
  </div>

  <script>
    function showSuccess(event) {
      event.preventDefault(); // stop page reload so the note stays visible

      var note = document.getElementById("successNote");
      note.style.display = "flex";

      document.getElementById("registerForm").reset();

      note.scrollIntoView({ behavior: "smooth", block: "start" });

      clearTimeout(window.__noteTimer);
      window.__noteTimer = setTimeout(function () {
        note.style.display = "none";
      }, 4000);

      // to actually save this patient to your Java backend later,
      // this is where you would call fetch(...) with the form fields
      return false;
    }
  </script>

</body>
</html>
