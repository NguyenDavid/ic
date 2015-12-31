package com.projetidoine.interceptors;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.projetidoine.entity.User;

public class AuthenticationInterceptor implements Interceptor {

	private static final long serialVersionUID = -5011962009065225959L;

	@Override
	public void destroy() {
		// Destruction des ressources crees après l'execution de l'interceptor
	}

	@Override
	public void init() {
		// Creation des ressources avant l'execution de l'interceptor
	}

	// C'est la methode qui s'execute quand on a une action qui necessite
	// l'authentification
	// elle permet de recuperer la session courante, verifier est ce que
	// l'utilisateur est bien authentifie, et apres invoque l'intercepteur
	// suivant dans le stack des intercepteurs
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		System.out.println("A l'intérieur de l'intercepteur");
		Map<String, Object> sessionAttributes = actionInvocation
				.getInvocationContext().getSession();

		User user = (User) sessionAttributes.get("user");
		if (sessionAttributes == null || user == null) {
			System.out.println("user : "+user);
			System.out.println("AuthentificationInterceptor input1");
			return Action.INPUT;
		} else {
			Action action = (Action) actionInvocation.getAction();
			if (!(user.getLogin() == null && user.getPassword() == null)) {
				if (action instanceof UserAware) {
					((UserAware) action).setUser(user);
				}
				return actionInvocation.invoke();
			} else {
				System.out.println("AuthentificationInterceptor input2");
				return Action.INPUT;
			}

		}
	}
}
