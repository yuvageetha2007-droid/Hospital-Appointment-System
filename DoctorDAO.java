package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DBConnection;
import model.Doctor;


public class DoctorDAO {


    // Add Doctor

    public void addDoctor(Doctor doctor) {


        String query = "INSERT INTO doctor(doctor_name, specialization, phone, email) VALUES(?,?,?,?)";


        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);


            ps.setString(1, doctor.getDoctorName());
            ps.setString(2, doctor.getSpecialization());
            ps.setString(3, doctor.getPhone());
            ps.setString(4, doctor.getEmail());


            int result = ps.executeUpdate();


            if(result > 0) {

                System.out.println("Doctor Added Successfully");

            }


        }
        catch(Exception e) {

            e.printStackTrace();

        }

    }



    // View Doctors

    public void viewDoctors() {


        String query = "SELECT * FROM doctor";


        try {


            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);


            ResultSet rs = ps.executeQuery();



            while(rs.next()) {


                System.out.println(
                    rs.getInt("doctor_id") +
                    " " +
                    rs.getString("doctor_name") +
                    " " +
                    rs.getString("specialization")
                );


            }


        }
        catch(Exception e) {

            e.printStackTrace();

        }

    }

}
