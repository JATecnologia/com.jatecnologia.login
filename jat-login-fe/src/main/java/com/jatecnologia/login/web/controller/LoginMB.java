package com.jatecnologia.login.web.controller;


import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.primefaces.context.RequestContext;

import com.jatecnologia.commons.core.encryption.EncryptionUtil;
import com.jatecnologia.login.core.entity.JATUser;
import com.jatecnologia.login.core.service.LoginService;

@ManagedBean(name="loginMB")
@SessionScoped
//@Named
//@ViewScoped
public class LoginMB implements Serializable{

	private static final long serialVersionUID = -9081097377940402506L;

	private String login;
	private String password;
	
	@Inject
	private LoginService	service;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	  public void login(javax.faces.event.ActionEvent actionEvent) { 
        RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg = null;  
        boolean loggedIn = false;  
        
        if (StringUtils.isBlank(login) || StringUtils.isEmpty(login)  || StringUtils.isBlank(password) ||StringUtils.isEmpty(password)){
        	msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
        }      
                
        JATUser user = service.findByLoginAndPassword(login);
          
        if(user!=null) {
        	
        	// Criptografa a senha informada na pagina de login
			String encryptedPassword = EncryptionUtil.generateHash(password, EncryptionUtil.SHA256);
        				
			if (!user.getPassword().equals(encryptedPassword)) {
				loggedIn = false;
				msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
        	}
			else{
			
//				try {
//					//Registra no dominio de segurança o usuario e senha
//					FacesContext fc = FacesContext.getCurrentInstance(); 
//					HttpServletRequest request = (HttpServletRequest)fc.getExternalContext().getRequest();	
//					request.login(login, password);
//					
//					System.out.println("============ ROLES ===============");
//					
//					System.out.println("USUARIO "   + FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName());
//					
//					System.out.println(FacesContext.getCurrentInstance().getExternalContext().isUserInRole("SECRETARIA_ROLE"));
//					System.out.println(FacesContext.getCurrentInstance().getExternalContext().isUserInRole("DIRETOR_ALUNO_ROLE"));
//	
//					System.out.println(FacesContext.getCurrentInstance().getExternalContext().isUserInRole("PUBLIC_ROLE"));
//	
//					System.out.println(FacesContext.getCurrentInstance().getExternalContext().isUserInRole("ADMIN_ROLE"));
//	
//					System.out.println(FacesContext.getCurrentInstance().getExternalContext().isUserInRole("SECRETARIA"));
//					System.out.println(FacesContext.getCurrentInstance().getExternalContext().isUserInRole("ADMIN"));
//	
//					System.out.println(FacesContext.getCurrentInstance().getExternalContext().isUserInRole("DIRETOR"));
//	
//					System.out.println(FacesContext.getCurrentInstance().getExternalContext().isUserInRole("SECRETARIA"));
//					System.out.println(FacesContext.getCurrentInstance().getExternalContext().isUserInRole("ALUNO"));
//					
//					System.out.println(request.isUserInRole("SECRETARIA_ROLE"));
//					System.out.println(request.isUserInRole("DIRETOR_ALUNO_ROLE"));
//					System.out.println(request.isUserInRole("PUBLIC_ROLE"));
//					System.out.println(request.isUserInRole("ADMIN_ROLE"));
//					
//					System.out.println(request.isUserInRole("SECRETARIA"));
//					System.out.println(request.isUserInRole("ADMIN"));
//					System.out.println(request.isUserInRole("ALUNO"));
//				} catch (Throwable e) {
//					e.printStackTrace();
//					msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
//				}			
        	
				loggedIn = true;  
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", login);
			}
        } else {  
        	
            loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");  
        }  
          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);  
    }  
}
