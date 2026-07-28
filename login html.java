<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login — PulseCare</title>
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
    max-width: 420px;
    margin: 60px auto;
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
      <span>Logged in successfully!</span>
    </div>

    <h2>Patient Login</h2>

    <form id="loginForm" onsubmit="return showSuccess(event)">
      <label for="email">Email</label>
      <input type="email" id="email" name="email" required>

      <label for="password">Password</label>
      <input type="password" id="password" name="password" required>

      <button type="submit">Login</button>
    </form>

    <p class="foot">Don't have an account? <a href="register.html">Register here</a></p>
  </div>

  <script>
    function showSuccess(event) {
      event.preventDefault(); // stop page reload so the note stays visible

      var note = document.getElementById("successNote");
      note.style.display = "flex";

      document.getElementById("loginForm").reset();

      note.scrollIntoView({ behavior: "smooth", block: "start" });

      clearTimeout(window.__noteTimer);
      window.__noteTimer = setTimeout(function () {
        note.style.display = "none";
      }, 4000);

      // to actually verify credentials against your Java backend later,
      // this is where you would call fetch(...) with email + password
      return false;
    }
  </script>

</body>
</html>
