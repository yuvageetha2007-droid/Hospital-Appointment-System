package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DBConnection;
import model.Patient;


public class PatientDAO {


    // Patient Register

    public void registerPatient(Patient patient) {


        String query = "INSERT INTO patient(name, age, gender, phone, email, password) VALUES(?,?,?,?,?,?)";


        try {


            Connection con = DBConnection.getConnection();


            PreparedStatement ps = con.prepareStatement(query);


            ps.setString(1, patient.getName());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getPhone());
            ps.setString(5, patient.getEmail());
            ps.setString(6, patient.getPassword());


            int result = ps.executeUpdate();


            if(result > 0){

                System.out.println("Patient Registered Successfully");

            }


        }
        catch(Exception e){

            e.printStackTrace();

        }

    }



    // Patient Login

    public boolean loginPatient(String email, String password){


        String query = "SELECT * FROM patient WHERE email=? AND password=?";


        try{


            Connection con = DBConnection.getConnection();


            PreparedStatement ps = con.prepareStatement(query);


            ps.setString(1,email);
            ps.setString(2,password);



            ResultSet rs = ps.executeQuery();



            if(rs.next()){

                return true;

            }


        }
        catch(Exception e){

            e.printStackTrace();

        }


        return false;

    }

}
