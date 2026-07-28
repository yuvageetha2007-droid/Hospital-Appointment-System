package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DBConnection;
import model.Prescription;


public class PrescriptionDAO {


    // Add Prescription

    public void addPrescription(Prescription prescription) {


        String query =
        "INSERT INTO prescription(appointment_id, medicine, description) VALUES(?,?,?)";


        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);


            ps.setInt(1, prescription.getAppointmentId());
            ps.setString(2, prescription.getMedicine());
            ps.setString(3, prescription.getDescription());


            int result = ps.executeUpdate();


            if(result > 0) {

                System.out.println("Prescription Added Successfully");

            }


        }
        catch(Exception e) {

            e.printStackTrace();

        }

    }



    // View Prescription

    public void viewPrescription(int appointmentId) {


        String query =
        "SELECT * FROM prescription WHERE appointment_id=?";


        try {


            Connection con = DBConnection.getConnection();


            PreparedStatement ps = con.prepareStatement(query);


            ps.setInt(1, appointmentId);


            ResultSet rs = ps.executeQuery();



            while(rs.next()) {


                System.out.println(
                    "Medicine : " + rs.getString("medicine")
                );


                System.out.println(
                    "Description : " + rs.getString("description")
                );

            }


        }
        catch(Exception e) {

            e.printStackTrace();

        }

    }

}
