package project.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import project.model.Cliente;
import project.model.User;
import project.service.UserService;

@Component
@Scope("view")
public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<User> userList;
	private List<User> userList2;
	
	private List<User> userListJPA;

	private User user;

	private String json;
	private List<Cliente> clienteList;
	
	//@ManagedProperty("#{userService}")
	@Autowired
	private UserService userService;

	@PostConstruct
	public void init() {
		this.userList2 = userService.getUserList();
		
		userList = userService.findAll();
		
		userListJPA = userService.findAllJPA();
		
		json = JsonApi.getJson();
		System.out.println(json);
		
		clienteList = JsonApi.getClienteList(json);
		
		for (Cliente cliente : clienteList) {
			System.out.println(cliente.getId() + " - " + cliente.getNome());
		}
	}

	public List<User> getUserList() {
		return userList;
	}
	
	public void save() {
		userService.save(user);
		user = new User();
		userList = userService.getUserList();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "User saved!", null));
	}
	
	public void edit() {
		
//		User user = userService.findUserById(this.user.getId());
//		user.setName(this.user.getName());
//		user.setEmail(this.user.getEmail());
		
		userService.updateUser(user);
		
		user = new User();
		userList = userService.getUserList();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "User edited!", null));
	}
	
	public void remove(User user) {
		userService.remove(user);
		userList = userService.getUserList();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "User removed!", null));
	}
	
	public void clear() {
		user = new User();
	}
	
	//=========
	
	public void saveJPA() {
		userService.saveJPA(user);
		user = new User();
		userList = userService.getUserList();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "User saved!", null));
	}
	
	public void removeJPA(User user) {
		userService.removeJPA(user);
		userList = userService.getUserList();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "User removed!", null));
	}

	public List<User> findAll() {
		return userService.findAll();
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserListJPA() {
		return userListJPA;
	}

	public void setUserListJPA(List<User> userListJPA) {
		this.userListJPA = userListJPA;
	}

	public List<User> getUserList2() {
		return userList2;
	}

	public void setUserList2(List<User> userList2) {
		this.userList2 = userList2;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public List<Cliente> getClienteList() {
		return clienteList;
	}

	public void setClienteList(List<Cliente> clienteList) {
		this.clienteList = clienteList;
	}

}
