package com.employee.controller;

import com.employee.dao.EmployeeDAO;
import com.employee.model.Employee;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@Named(value = "employeeBean")
@SessionScoped
public class EmployeeBean implements Serializable {

    private Employee employee;
    private EmployeeDAO employeeDAO;
    private List<Employee> employees;

    public EmployeeBean() {
        employee = new Employee();
        employeeDAO = new EmployeeDAO();
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Employee> getEmployees() {
        employees = employeeDAO.selectAllEmployees();
        return employees;
    }

    public String addEmployee() {
        try {
            employeeDAO.insertEmployee(employee);
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Employee added successfully"));
            employee = new Employee();
            return "index.xhtml?faces-redirect=true";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to add employee"));
            return null;
        }
    }

    public String loadEmployee(int id) {
        this.employee = employeeDAO.selectEmployee(id);
        return "edit-employee.xhtml?faces-redirect=true";
    }

    public String updateEmployee() {
        try {
            employeeDAO.updateEmployee(employee);
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Employee updated successfully"));
            employee = new Employee();
            return "index.xhtml?faces-redirect=true";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to update employee"));
            return null;
        }
    }

    public void deleteEmployee(int id) {
        try {
            employeeDAO.deleteEmployee(id);
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Employee deleted successfully"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to delete employee"));
        }
    }
}
