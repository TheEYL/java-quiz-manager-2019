package fr.epita.quiz.datamodel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leo
 * POJO list of administrators
 */
public class AdminList {

	private List<Admin> adminList;
	public AdminList() {
		adminList = new ArrayList<>();

	}
	public List<Admin> getAdminList() {
		return adminList;
	}

	public void setAdminList(List<Admin> adminList) {
		this.adminList = adminList;
	}
}
