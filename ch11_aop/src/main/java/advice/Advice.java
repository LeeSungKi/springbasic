package advice;

import org.aspectj.lang.Signature;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;


public class Advice {
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	public void myBefore(JoinPoint jPoint) {
		Signature s = jPoint.getSignature();
		System.out.println("before:"+s);
	
		/*String id = session.getAttribute("currentId");*/
		}

	public void myAfter(JoinPoint jPoint) {
		Signature s = jPoint.getSignature();
		System.out.println("after :"+s);
		System.out.println("s.getName():"+s.getName());
		System.out.println("s.toLongString():"+s.toLongString());
	}

}









