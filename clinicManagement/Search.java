package com.bridgeit.objectoriented.clinicManagement;

import java.util.List;

public class Search {
	/**
	 * to search the doctor by name
	 * 
	 * @param searchName
	 * @param doctorList
	 * @return
	 */
	public boolean searchDocByName(String searchName, List<Doctor> doctorList) {
		int count = 0;
		for (int i = 0; i < doctorList.size(); i++) {
			count = 0;
			String name = doctorList.get(i).getName();
			if (searchName.compareTo(name) == 0) {
				System.out.println("\nDoctor Found!");
				System.out.printf("\n%-15s %-10s  %-15s %15s\n", "Doctor Name", "Doctor Id", "Specialization",
						"Availability");
				System.out.println("------------------------------------------------------------------");
				System.out.println(doctorList.get(i).toString());
				break;
			} else {
				count++;
			}
		}
		if (count != 0) {
			System.out.println("\nDoctor not Found!");
			return false;
		} else {
			return true;
		}
	}

	/**
	 * to search doctor by id
	 * 
	 * @param searchId
	 * @param doctorList
	 */
	public void searchDocById(int searchId, List<Doctor> doctorList) {
		int count = 0;
		for (int i = 0; i < doctorList.size(); i++) {
			count = 0;
			int id = doctorList.get(i).getId();
			if (searchId == id) {
				System.out.println("\nDoctor Found!");
				System.out.printf("\n%-15s %-10s  %-15s %15s\n", "Doctor Name", "Doctor Id", "Specialization",
						"Availability");
				System.out.println("-------------------------------------------------------------------");
				System.out.println(doctorList.get(i).toString());
				break;
			} else {
				count++;
			}
		}
		if (count != 0) {
			System.out.println("\nDoctor not Found!");
		}
	}

	/**
	 * to search doctor by id
	 * 
	 * @param searchSPL
	 * @param doctorList
	 */

	public void searchDocBySPL(String searchSPL, List<Doctor> doctorList) {
		int count = 0;
		for (int i = 0; i < doctorList.size(); i++) {
			count = 0;
			String spl = doctorList.get(i).getSpecialization();
			if (searchSPL.compareTo(spl) == 0) {
				System.out.println("\nDoctor Found!");
				System.out.printf("\n%-15s %-10s  %-15s %15s\n", "Doctor Name", "Doctor Id", "Specialization",
						"Availability");
				System.out.println("------------------------------------------------------------------");
				System.out.println(doctorList.get(i).toString());
				break;
			} else {
				count++;
			}
		}
		if (count != 0) {
			System.out.println("\nDoctor not Found!");
		}
	}

	/**
	 * search doctor by availability
	 * 
	 * @param searchAVL
	 * @param doctorList
	 */
	public void searchDocByAvl(String searchAVL, List<Doctor> doctorList) {
		int count = 0;
		for (int i = 0; i < doctorList.size(); i++) {
			count = 0;
			String avl = doctorList.get(i).getAvl();
			if (searchAVL.compareTo(avl) == 0) {
				System.out.println("\nDoctor Found!");
				System.out.printf("\n%-15s %-10s  %-15s %15s\n", "Doctor Name", "Doctor Id", "Specialization",
						"Availability");
				System.out.println("----------------------------------------------------------------");
				System.out.println(doctorList.get(i).toString());
				break;
			} else {
				count++;
			}
		}
		if (count != 0) {
			System.out.println("\nDoctor not Found!");
		}
	}

	/**
	 * search patient by name
	 * 
	 * @param searchName
	 * @param patientList
	 * @return
	 */

	public boolean searchPatientByName(String searchName, List<Patient> patientList) {
		int count = 0;
		for (int i = 0; i < patientList.size(); i++) {
			count = 0;
			String patientName = patientList.get(i).getName();
			if (searchName.compareTo(patientName) == 0) {
				System.out.println("\nPatient Found!");
				System.out.printf("\n%-15s %-10s  %-15s %15s\n", "Patient Name", "Patient Id", "Mobile Number", "Age");
				System.out.println("--------------------------------------------------------------------");
				System.out.println(patientList.get(i).toString());
				break;
			} else {
				count++;
			}
		}
		if (count != 0) {
			System.out.println("\nPatient not found!");
			return false;
		} else {
			return true;
		}
	}

	/**
	 * search patient by id
	 * 
	 * @param searchId
	 * @param patientList
	 */

	public void searchPatientById(int searchId, List<Patient> patientList) {
		int count = 0;
		for (int i = 0; i < patientList.size(); i++) {
			count = 0;
			int id = patientList.get(i).getId();
			if (searchId == id) {
				System.out.println("\nPatient Found!");
				System.out.printf("\n%-15s %-10s  %-15s %15s\n", "Patient Name", "Patient Id", "Mobile Number", "Age");
				System.out.println("-----------------------------------------------------------------");
				System.out.println(patientList.get(i).toString());
				break;
			} else {
				count++;
			}
		}
		if (count != 0) {
			System.out.println("\nPatient not found!");
		}
	}

	/**
	 * search patient by mobile number
	 * 
	 * @param searchMobNum
	 * @param patientList
	 */
	public void searchPatientByMobNum(String searchMobNum, List<Patient> patientList) {
		int count = 0;
		for (int i = 0; i < patientList.size(); i++) {
			count = 0;
			String patientMobNum = patientList.get(i).getMobNumber();
			if (searchMobNum.compareTo(patientMobNum) == 0) {
				System.out.println("\nPatient Found!");
				System.out.printf("\n%-15s %-10s  %-15s %15s\n", "Patient Name", "Patient Id", "Mobile Number", "Age");
				System.out.println("-------------------------------------------------------------------");
				System.out.println(patientList.get(i).toString());
				break;
			} else {
				count++;
			}
		}
		if (count != 0) {
			System.out.println("\nPatient not found!");
		}
	}

	/**
	 * search patient by age
	 * 
	 * @param searchAge
	 * @param patientList
	 */

	public void searchPatientByAge(int searchAge, List<Patient> patientList) {
		int count = 0;
		for (int i = 0; i < patientList.size(); i++) {
			count = 0;
			int patientAge = patientList.get(i).getAge();
			if (searchAge == patientAge) {
				System.out.println("\nPatient Found!");
				System.out.printf("\n%-15s %-10s  %-15s %15s\n", "Patient Name", "Patient Id", "Mobile Number", "Age");
				System.out.println("------------------------------------------------------------------------");
				System.out.println(patientList.get(i).toString());
				break;
			} else {
				count++;
			}
		}
		if (count != 0) {
			System.out.println("\nPatient not found");
		}
	}

	/**
	 * to get appointment to doctor
	 * 
	 * @param searchName
	 * @param appointmentList
	 * @return
	 */

	public int getAppointedDocIndex(String searchName, List<Appointment> appointmentList) {
		int index = -1;
		for (int i = appointmentList.size() - 1; i >= 0; i--) {
			String docName = appointmentList.get(i).getDoctorName();
			if (searchName.compareTo(docName) == 0) {
				index = i;
				break;
			}

		}

		return index;
	}
}
