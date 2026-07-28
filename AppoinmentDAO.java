package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DBConnection;
import model.Appointment;


public class AppointmentDAO {


    // Book Appointment

    public void bookAppointment(Appointment appointment) {


        String query = 
        "INSERT INTO appointment(patient_id, doctor_id, date, time, status) VALUES(?,?,?,?,?)";


        try {


            Connection con = DBConnection.getConnection();


            PreparedStatement ps = con.prepareStatement(query);


            ps.setInt(1, appointment.getPatientId());
            ps.setInt(2, appointment.getDoctorId());
            ps.setString(3, appointment.getDate());
            ps.setString(4, appointment.getTime());
            ps.setString(5, appointment.getStatus());


            int result = ps.executeUpdate();


            if(result > 0) {

                System.out.println("Appointment Booked Successfully");

            }


        }
        catch(Exception e) {

            e.printStackTrace();

        }

    }



    // Cancel Appointment

    public void cancelAppointment(int appointmentId) {


        String query =
        "UPDATE appointment SET status='Cancelled' WHERE appointment_id=?";


        try {


            Connection con = DBConnection.getConnection();


            PreparedStatement ps = con.prepareStatement(query);


            ps.setInt(1, appointmentId);


            int result = ps.executeUpdate();


            if(result > 0) {

                System.out.println("Appointment Cancelled");

            }


        }
        catch(Exception e) {

            e.printStackTrace();

        }

    }



    // View Appointments

    public void viewAppointments() {


        String query = "SELECT * FROM appointment";


        try {


            Connection con = DBConnection.getConnection();


            PreparedStatement ps = con.prepareStatement(query);


            ResultSet rs = ps.executeQuery();



            while(rs.next()) {


                System.out.println(
                    rs.getInt("appointment_id")
                    + " Patient:"
                    + rs.getInt("patient_id")
                    + " Doctor:"
                    + rs.getInt("doctor_id")
                    + " Status:"
                    + rs.getString("status")
                );

            }


        }
        catch(Exception e) {

            e.printStackTrace();

        }

    }

}
