package dao;

import java.util.List;

import entity.Employee;

public interface IEmployeeDAO {
	public List<Employee> findAll(String orderby,int page) throws Exception;

	public void add(Employee employee) throws Exception;

	// ɾ���ķ���
	public void deleleById(int id) throws Exception;

	// ͨ��id���Ӧ����Ϣ
	public Employee findById(int id) throws Exception;

	// ��������
	public void update(Employee e) throws Exception;

	public List<Employee> findByName(String sqlname) throws Exception;
}
