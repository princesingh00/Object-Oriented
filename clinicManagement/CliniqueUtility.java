package com.bridgeit.objectoriented.clinicManagement;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class CliniqueUtility implements CliniqueInterface {
	public static ObjectMapper objM = new ObjectMapper();
	static Scanner sc = new Scanner(System.in);
	static Scanner sc1 = new Scanner(System.in);

	public static void addDoctor(List<Doctor> doctorList) {
		String doctorFile = "/home/user/Doctor.json";

		System.out.println("Enter the Doctor's name");
		String name = sc.nextLine().toUpperCase();
		System.out.println("Enter the DOctor's id:");
		int id = sc1.nextInt();
		System.out.println("Enter the Specialization");

		String spl = sc.nextLine().toUpperCase();
		System.out.println("Enter the Availability");
		String avl = sc.nextLine().toUpperCase();

		Doctor newDoctor = new Doctor(name, id, spl, avl);
		doctorList.add(newDoctor);
		try {
			objM.writerWithDefaultPrettyPrinter().writeValue(new File(doctorFile), doctorList);
			System.out.println("\nNew Doctor Added!\n");
			System.out.printf("%-15s %-10s  %-15s %15s\n", "Doctor Name", "Doctor Id", "Specialization",
					"Availability");
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println(newDoctor.toString());
		} catch (IOException e) {
			System.out.println("" + e.getMessage());
			e.printStackTrace();
		}

	}

	public static void addPatient(List<Patient> patientList) {

		System.out.println("Enter the patient's name:");
		String name = sc.nextLine().toUpperCase();
		System.out.println("Enter the Patient's id:");
		int id = sc1.nextInt();
		System.out.println("Enter the Mobile number:");
		String mobNum = sc.nextLine();
		System.out.println("Enter the Patient's age:");
		int age = sc.nextInt();

		Patient newPatient = new Patient(name, id, mobNum, age);
		patientList.add(newPatient);

		try {
			objM.writerWithDefaultPrettyPrinter().writeValue(new File(patientFile), patientList);
			System.out.println("\nNew Patient Added!\n");
			System.out.printf("%-15s %-10s  %-15s %15s\n", "Patient Name", "Patient Id", "Mobile Number", "Age");
			System.out.println("----------------------------------------------------------------------------");
			System.out.println(newPatient.toString());
		} catch (IOException e) {
			System.out.println("" + e.getMessage());
			e.printStackTrace();
		}

	}

	public static void searchDoctors(List<Doctor> doctorList) {
		Search searchStart = new Search();

		System.out.println("Enter the choice");
		System.out.println("\t1. By Name");
		System.out.println("\t2. By ID");
		System.out.println("\t3. By Specialization");
		System.out.println("\t4. By Availability");
		int n = sc1.nextInt();

		switch (n) {
		case 1:
			System.out.println("Enter the Doctor's name:");
			String doctname = sc.nextLine().toUpperCase();
			searchStart.searchDocByName(doctname, doctorList);
			break;

		case 2:
			System.out.println("Enter the Doctor's ID:");
			int doctid = sc1.nextInt();
			searchStart.searchDocById(doctid, doctorList);
			break;

		case 3:
			System.out.println("Enter the Specialization");
			String doctspec = sc.nextLine().toUpperCase();
			searchStart.searchDocBySPL(doctspec, doctorList);
			break;

		case 4:
			System.out.println("Enter the Availability");
			String doctavai = sc.nextLine().toUpperCase();
			searchStart.searchDocByAvl(doctavai, doctorList);
			break;

		default:
			System.out.println("\tinvalid choice");
		}
	}

	public static void searchPatients(List<Patient> patientList) {
		Search searchStart = new Search();

		System.out.println("Enter the Choice");
		System.out.println("\t1. By Name");
		System.out.println("\t2. By ID");
		System.out.println("\t3. By Mobile Number");
		System.out.println("\t4. By Age");
		int n = sc1.nextInt();

		switch (n) {
		case 1:
			System.out.println("Enter the Patient's name:");
			String pname = sc.nextLine().toUpperCase();
			searchStart.searchPatientByName(pname, patientList);
			break;

		case 2:
			System.out.println("Enter the Patient's Id");
			int pid = sc1.nextInt();
			searchStart.searchPatientById(pid, patientList);
			break;

		case 3:
			System.out.println("Enter the patient phone no.:");
			String pmobnum = sc.nextLine().toUpperCase();
			searchStart.searchPatientByMobNum(pmobnum, patientList);
			break;

		case 4:
			System.out.println("Enter the Patient age");
			int page = sc1.nextInt();
			searchStart.searchPatientByAge(page, patientList);
			break;

		default:
			System.out.println("\tinvalid choice");
		}
	}

	public static void fixAppointment(List<Doctor> doctorList, List<Patient> patientList) // List<Appointment>
																							// appointmentList
	{
		String appointmentFile = "/home/user/Appointments.json";
		try {
			List<Appointment> appointmentList = objM.readValue(new File(appointmentFile),
					new TypeReference<List<Appointment>>() {
					});

			Search searchStart = new Search();
			System.out.println("Enter the Doctor's name:");
			String doctorName = sc.nextLine().toUpperCase();
			if (searchStart.searchDocByName(doctorName, doctorList) == true) {
				System.out.println("Enter the patient's name:");
				String patientName = sc.nextLine().toUpperCase();
				if (searchStart.searchPatientByName(patientName, patientList) == true) {
					System.out.println("Enter the date(DD/MM/YYYY): ");
					String date = sc.nextLine();
					int index = searchStart.getAppointedDocIndex(doctorName, appointmentList);
					int docCount;

					if (index == -1) {
						docCount = 1;
					} else {
						docCount = appointmentList.get(index).getDocAppointmentCount();
						docCount = docCount + 1;
					}
					if (docCount <= 5) {
						Appointment newAppointment = new Appointment(doctorName, patientName, date, docCount);
						appointmentList.add(newAppointment);
						objM.writerWithDefaultPrettyPrinter().writeValue(new File(appointmentFile), appointmentList);

						System.out.println("\nAppointment Added!\n");
						System.out.printf("%-20s %-20s %-10s\n", "Doctor Name", "Patient Name", "Date of Appointment");
						System.out.println("--------------------------------------------------------------------");
						System.out.println(newAppointment.toString());
					} else {
						System.out.println("Sorry.. Doctor's not available right now!");
					}
				}
			}

		} catch (IOException e) {
			System.out.println("" + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void printAppointments(List<Appointment> appointmentList) {
		String appointmentFile = "/home/user/Appointments.json";
		try {
			List<Appointment> appointmentList1 = objM.readValue(new File(appointmentFile),
					new TypeReference<List<Appointment>>() {
					});

			System.out.println("-------------------List of Appointments--------------------");
			System.out.printf("%-20s %-20s %-10s\n", "Doctor Name", "Patient Name", "Date of Appointment");
			System.out.println("----------------------------------------------------------------------");
			for (int i = 0; i < appointmentList1.size(); i++) {
				System.out.println(appointmentList1.get(i).toString());
			}
		} catch (IOException e) {
			System.out.println("" + e.getMessage());
			e.printStackTrace();
		}
	}
}
