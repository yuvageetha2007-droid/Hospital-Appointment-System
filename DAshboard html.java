<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>PulseCare — Patient Dashboard</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link href="https://fonts.googleapis.com/css2?family=Fraunces:opsz,wght@9..144,400;9..144,500;9..144,600&family=Inter:wght@400;500;600;700&family=IBM+Plex+Mono:wght@400;500&display=swap" rel="stylesheet">
<style>
  :root{
    --bg: #EEF1ED;
    --surface: #FFFFFF;
    --ink: #1F2E2B;
    --ink-soft: #5B6B63;
    --teal: #3E7C6B;
    --teal-deep: #2C5A4D;
    --amber: #E4A340;
    --amber-deep: #C9862A;
    --hairline: #D8DED9;
    --danger: #C4563F;
    --radius: 14px;
  }

  *{ box-sizing: border-box; }

  html{ scroll-behavior: smooth; }

  body{
    margin: 0;
    background: var(--bg);
    color: var(--ink);
    font-family: 'Inter', sans-serif;
    line-height: 1.5;
    -webkit-font-smoothing: antialiased;
  }

  a{ color: inherit; text-decoration: none; }

  .display{ font-family: 'Fraunces', serif; }
  .mono{ font-family: 'IBM Plex Mono', monospace; letter-spacing: 0.02em; }

  /* ---------- Nav ---------- */
  .nav{
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 22px 40px;
    max-width: 1200px;
    margin: 0 auto;
  }
  .nav__brand{
    display: flex;
    align-items: center;
    gap: 10px;
    font-family: 'Fraunces', serif;
    font-size: 21px;
    font-weight: 600;
    color: var(--teal-deep);
  }
  .nav__brand .dot{
    width: 9px; height: 9px; border-radius: 50%;
    background: var(--amber);
    display: inline-block;
  }
  .nav__links{
    display: flex;
    gap: 32px;
    font-size: 14.5px;
    font-weight: 500;
    color: var(--ink-soft);
  }
  .nav__links a{
    padding: 6px 2px;
    border-bottom: 2px solid transparent;
    transition: color .15s ease, border-color .15s ease;
  }
  .nav__links a:hover, .nav__links a:focus-visible{
    color: var(--ink);
    border-color: var(--amber);
  }
  .nav__links a.active{ color: var(--teal-deep); border-color: var(--teal-deep); }

  /* ---------- Hero ---------- */
  .hero{
    max-width: 1200px;
    margin: 0 auto;
    padding: 28px 40px 8px;
  }
  .hero__eyebrow{
    font-family: 'IBM Plex Mono', monospace;
    font-size: 12.5px;
    letter-spacing: 0.08em;
    text-transform: uppercase;
    color: var(--teal);
    margin: 0 0 6px;
  }
  .hero h1{
    font-family: 'Fraunces', serif;
    font-weight: 500;
    font-size: clamp(28px, 4vw, 42px);
    margin: 0 0 6px;
    color: var(--ink);
  }
  .hero h1 span{ color: var(--teal-deep); }
  .hero p{
    color: var(--ink-soft);
    font-size: 15.5px;
    margin: 0 0 22px;
    max-width: 480px;
  }

  /* Signature pulse-line */
  .pulse{
    width: 100%;
    height: 46px;
    margin-bottom: 26px;
  }
  .pulse path{
    fill: none;
    stroke: var(--teal);
    stroke-width: 2;
    stroke-linecap: round;
    stroke-linejoin: round;
    stroke-dasharray: 620;
    stroke-dashoffset: 620;
    animation: draw 2.2s ease-out forwards;
  }
  .pulse circle{
    fill: var(--amber);
    opacity: 0;
    animation: pop .4s ease-out 2.1s forwards;
  }
  @keyframes draw{ to{ stroke-dashoffset: 0; } }
  @keyframes pop{ to{ opacity: 1; } }
  @media (prefers-reduced-motion: reduce){
    .pulse path{ animation: none; stroke-dashoffset: 0; }
    .pulse circle{ animation: none; opacity: 1; }
  }

  /* ---------- Stat strip ---------- */
  .stats{
    max-width: 1200px;
    margin: 0 auto;
    padding: 0 40px;
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    gap: 16px;
    margin-bottom: 36px;
  }
  .stat{
    background: var(--surface);
    border: 1px solid var(--hairline);
    border-radius: var(--radius);
    padding: 18px 20px;
  }
  .stat__label{
    font-family: 'IBM Plex Mono', monospace;
    font-size: 11.5px;
    text-transform: uppercase;
    letter-spacing: 0.06em;
    color: var(--ink-soft);
    margin: 0 0 8px;
  }
  .stat__value{
    font-family: 'Fraunces', serif;
    font-size: 26px;
    font-weight: 500;
    color: var(--ink);
  }
  .stat__value small{
    font-family: 'Inter', sans-serif;
    font-size: 13px;
    font-weight: 500;
    color: var(--ink-soft);
    margin-left: 6px;
  }

  /* ---------- Main grid ---------- */
  .grid{
    max-width: 1200px;
    margin: 0 auto;
    padding: 0 40px 60px;
    display: grid;
    grid-template-columns: 1.6fr 1fr;
    gap: 20px;
  }

  .panel{
    background: var(--surface);
    border: 1px solid var(--hairline);
    border-radius: var(--radius);
    padding: 26px;
  }
  .panel + .panel{ margin-top: 20px; }
  .panel__head{
    display: flex;
    align-items: baseline;
    justify-content: space-between;
    margin-bottom: 18px;
  }
  .panel__head h2{
    font-family: 'Fraunces', serif;
    font-weight: 500;
    font-size: 19px;
    margin: 0;
  }
  .panel__head a{
    font-size: 13px;
    font-weight: 600;
    color: var(--teal-deep);
  }
  .panel__head a:hover{ text-decoration: underline; }

  /* Appointment row */
  .appt{
    display: flex;
    align-items: center;
    gap: 16px;
    padding: 14px 0;
    border-top: 1px solid var(--hairline);
  }
  .appt:first-of-type{ border-top: none; padding-top: 0; }
  .appt__time{
    font-family: 'IBM Plex Mono', monospace;
    font-size: 13px;
    color: var(--teal-deep);
    background: #EAF2EF;
    padding: 6px 10px;
    border-radius: 8px;
    white-space: nowrap;
  }
  .appt__body h3{
    font-size: 15px;
    font-weight: 600;
    margin: 0 0 2px;
  }
  .appt__body p{
    font-size: 13px;
    color: var(--ink-soft);
    margin: 0;
  }
  .badge{
    margin-left: auto;
    font-size: 11.5px;
    font-weight: 600;
    padding: 4px 10px;
    border-radius: 20px;
  }
  .badge--confirmed{ background: #EAF2EF; color: var(--teal-deep); }
  .badge--pending{ background: #FCF1DE; color: var(--amber-deep); }

  /* Doctor card */
  .doctor{
    display: flex;
    align-items: center;
    gap: 14px;
    padding: 12px 0;
    border-top: 1px solid var(--hairline);
  }
  .doctor:first-of-type{ border-top: none; padding-top: 0; }
  .doctor__avatar{
    width: 42px; height: 42px;
    border-radius: 50%;
    background: linear-gradient(135deg, var(--teal), var(--teal-deep));
    color: #fff;
    display: flex; align-items: center; justify-content: center;
    font-family: 'Fraunces', serif;
    font-weight: 600;
    font-size: 15px;
    flex-shrink: 0;
  }
  .doctor h3{ font-size: 14.5px; font-weight: 600; margin: 0 0 2px; }
  .doctor p{ font-size: 12.5px; color: var(--ink-soft); margin: 0; }

  /* Prescription list */
  .rx{
    padding: 12px 0;
    border-top: 1px solid var(--hairline);
  }
  .rx:first-of-type{ border-top: none; padding-top: 0; }
  .rx__name{ font-size: 14.5px; font-weight: 600; }
  .rx__meta{ font-size: 12.5px; color: var(--ink-soft); margin-top: 2px; }

  /* Quick actions */
  .actions{
    display: flex;
    flex-direction: column;
    gap: 10px;
  }
  .btn{
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 13px 16px;
    border-radius: 10px;
    font-size: 14px;
    font-weight: 600;
    border: 1px solid var(--hairline);
    background: #fff;
    transition: transform .12s ease, border-color .12s ease, background .12s ease;
  }
  .btn:hover, .btn:focus-visible{
    border-color: var(--teal);
    transform: translateX(2px);
  }
  .btn--primary{
    background: var(--teal-deep);
    color: #fff;
    border-color: var(--teal-deep);
  }
  .btn--primary:hover, .btn--primary:focus-visible{
    background: var(--teal);
    border-color: var(--teal);
  }
  .btn--danger-outline{
    border-color: #EBD3CC;
    color: var(--danger);
  }
  .btn--danger-outline:hover, .btn--danger-outline:focus-visible{
    border-color: var(--danger);
  }
  .btn span.arrow{ opacity: .6; }

  a:focus-visible, button:focus-visible{
    outline: 2px solid var(--amber);
    outline-offset: 2px;
  }

  footer{
    text-align: center;
    padding: 30px 20px 40px;
    color: var(--ink-soft);
    font-size: 12.5px;
  }

  @media (max-width: 880px){
    .nav{ padding: 18px 20px; flex-wrap: wrap; gap: 10px; }
    .nav__links{ gap: 18px; font-size: 13px; }
    .hero{ padding: 20px 20px 4px; }
    .stats{ grid-template-columns: 1fr; padding: 0 20px; }
    .grid{ grid-template-columns: 1fr; padding: 0 20px 40px; }
  }
</style>
</head>
<body>

  <nav class="nav">
    <div class="nav__brand"><span class="dot"></span>PulseCare</div>
    <div class="nav__links">
      <a href="dashboard.html" class="active">Dashboard</a>
      <a href="Appointment.html">Appointments</a>
      <a href="Doctor.html">Doctors</a>
      <a href="cancel.html">Cancel Visit</a>
      <a href="login.html">Log out</a>
    </div>
  </nav>

  <header class="hero">
    <p class="hero__eyebrow">Patient dashboard</p>
    <h1>Good morning, <span>Arun</span>.</h1>
    <p>Here's what's ahead for you today, and what needs your attention.</p>

    <svg class="pulse" viewBox="0 0 600 46" preserveAspectRatio="none" aria-hidden="true">
      <path d="M0,23 L120,23 L145,6 L165,40 L185,23 L230,23 L250,14 L268,32 L286,23 L600,23"/>
      <circle cx="268" cy="32" r="4"/>
    </svg>
  </header>

  <section class="stats">
    <div class="stat">
      <p class="stat__label">Next appointment</p>
      <p class="stat__value">4:30 <small>PM · Today</small></p>
    </div>
    <div class="stat">
      <p class="stat__label">Active prescriptions</p>
      <p class="stat__value">2 <small>ongoing</small></p>
    </div>
    <div class="stat">
      <p class="stat__label">Doctors under care</p>
      <p class="stat__value">3 <small>specialists</small></p>
    </div>
  </section>

  <main class="grid">

    <div>
      <section class="panel">
        <div class="panel__head">
          <h2>Upcoming appointments</h2>
          <a href="Appointment.html">Book new →</a>
        </div>

        <div class="appt">
          <span class="appt__time mono">4:30 PM</span>
          <div class="appt__body">
            <h3>Dr. Arun Kumar</h3>
            <p>Cardiology · Room 204</p>
          </div>
          <span class="badge badge--confirmed">Confirmed</span>
        </div>

        <div class="appt">
          <span class="appt__time mono">Fri 10:00</span>
          <div class="appt__body">
            <h3>Dr. Meena Rao</h3>
            <p>General Physician · Room 101</p>
          </div>
          <span class="badge badge--pending">Pending</span>
        </div>

        <div class="appt">
          <span class="appt__time mono">Mon 2:15</span>
          <div class="appt__body">
            <h3>Dr. Suresh Babu</h3>
            <p>Orthopedic · Room 310</p>
          </div>
          <span class="badge badge--confirmed">Confirmed</span>
        </div>
      </section>

      <section class="panel">
        <div class="panel__head">
          <h2>Your prescriptions</h2>
          <a href="#">View all →</a>
        </div>

        <div class="rx">
          <p class="rx__name">Amoxicillin 500mg</p>
          <p class="rx__meta">Twice daily, after food · Prescribed by Dr. Arun Kumar</p>
        </div>
        <div class="rx">
          <p class="rx__name">Atorvastatin 10mg</p>
          <p class="rx__meta">Once daily, night · Prescribed by Dr. Meena Rao</p>
        </div>
      </section>
    </div>

    <div>
      <section class="panel">
        <div class="panel__head"><h2>Quick actions</h2></div>
        <div class="actions">
          <a class="btn btn--primary" href="Appointment.html">Book appointment <span class="arrow">→</span></a>
          <a class="btn" href="Doctor.html">View doctors <span class="arrow">→</span></a>
          <a class="btn" href="register.html">Register new patient <span class="arrow">→</span></a>
          <a class="btn btn--danger-outline" href="cancel.html">Cancel an appointment <span class="arrow">→</span></a>
        </div>
      </section>

      <section class="panel">
        <div class="panel__head"><h2>Your doctors</h2></div>

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
      </section>
    </div>

  </main>

  <footer>PulseCare · Hospital Management System</footer>

</body>
</html>
