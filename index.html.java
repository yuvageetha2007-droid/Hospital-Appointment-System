<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>PulseCare — Hospital Management System</title>
<style>
  *{ box-sizing: border-box; }
  body{
    margin: 0;
    font-family: 'Segoe UI', Arial, sans-serif;
    background: #EEF1ED;
    color: #1F2E2B;
  }
  a{ text-decoration: none; color: inherit; }

  .nav{
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 20px 40px;
    max-width: 1100px;
    margin: 0 auto;
  }
  .nav__brand{
    display: flex;
    align-items: center;
    gap: 8px;
    font-size: 20px;
    font-weight: 700;
    color: #2C5A4D;
  }
  .nav__brand .dot{
    width: 9px; height: 9px; border-radius: 50%;
    background: #E4A340;
    display: inline-block;
  }
  .nav__links{
    display: flex;
    gap: 12px;
  }
  .nav__links a{
    padding: 9px 18px;
    border-radius: 8px;
    font-size: 14px;
    font-weight: 600;
  }
  .nav__links a.outline{
    border: 1px solid #2C5A4D;
    color: #2C5A4D;
  }
  .nav__links a.outline:hover{ background: #EAF2EF; }
  .nav__links a.solid{
    background: #2C5A4D;
    color: #fff;
  }
  .nav__links a.solid:hover{ background: #3E7C6B; }

  .hero{
    max-width: 1100px;
    margin: 0 auto;
    padding: 50px 40px 20px;
    text-align: center;
  }
  .hero p.eyebrow{
    font-size: 13px;
    letter-spacing: 0.08em;
    text-transform: uppercase;
    color: #3E7C6B;
    font-weight: 700;
    margin: 0 0 10px;
  }
  .hero h1{
    font-size: clamp(30px, 5vw, 46px);
    margin: 0 0 14px;
    line-height: 1.15;
  }
  .hero h1 span{ color: #2C5A4D; }
  .hero p.sub{
    color: #5B6B63;
    font-size: 16px;
    max-width: 520px;
    margin: 0 auto 30px;
  }
  .hero .cta{
    display: inline-flex;
    gap: 14px;
    flex-wrap: wrap;
    justify-content: center;
  }
  .cta a{
    padding: 14px 26px;
    border-radius: 9px;
    font-size: 15px;
    font-weight: 700;
  }
  .cta a.solid{ background: #2C5A4D; color: #fff; }
  .cta a.solid:hover{ background: #3E7C6B; }
  .cta a.outline{ border: 1px solid #2C5A4D; color: #2C5A4D; }
  .cta a.outline:hover{ background: #EAF2EF; }

  .features{
    max-width: 1100px;
    margin: 50px auto 70px;
    padding: 0 40px;
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    gap: 18px;
  }
  .card{
    background: #fff;
    border: 1px solid #D8DED9;
    border-radius: 14px;
    padding: 24px;
  }
  .card .icon{
    width: 40px; height: 40px;
    border-radius: 10px;
    background: #EAF2EF;
    color: #2C5A4D;
    display: flex; align-items: center; justify-content: center;
    font-size: 18px;
    margin-bottom: 14px;
  }
  .card h3{ margin: 0 0 6px; font-size: 16px; }
  .card p{ margin: 0; font-size: 13.5px; color: #5B6B63; line-height: 1.5; }

  footer{
    text-align: center;
    padding: 30px 20px 40px;
    color: #5B6B63;
    font-size: 12.5px;
  }

  @media (max-width: 780px){
    .nav{ flex-direction: column; gap: 14px; padding: 20px; }
    .features{ grid-template-columns: 1fr; padding: 0 20px; }
  }
</style>
</head>
<body>

  <nav class="nav">
    <div class="nav__brand"><span class="dot"></span>PulseCare</div>
    <div class="nav__links">
      <a class="outline" href="login.html">Login</a>
      <a class="solid" href="register.html">Register</a>
    </div>
  </nav>

  <section class="hero">
    <p class="eyebrow">Hospital Management System</p>
    <h1>Care that's <span>organised</span>,<br>from the first visit.</h1>
    <p class="sub">Book appointments, track prescriptions, and stay connected with your doctors — all in one place.</p>
    <div class="cta">
      <a class="solid" href="register.html">Register as a Patient</a>
      <a class="outline" href="login.html">I already have an account</a>
    </div>
  </section>

  <section class="features">
    <div class="card">
      <div class="icon">📅</div>
      <h3>Book appointments</h3>
      <p>Choose a doctor, pick a time that works, and confirm in seconds.</p>
    </div>
    <div class="card">
      <div class="icon">🩺</div>
      <h3>Find the right doctor</h3>
      <p>Browse doctors by specialization and see who's available.</p>
    </div>
    <div class="card">
      <div class="icon">💊</div>
      <h3>Track prescriptions</h3>
      <p>Keep every prescription and dosage in one dashboard.</p>
    </div>
  </section>

  <footer>PulseCare · Hospital Management System</footer>

</body>
</html>
