package pjt_tournois_e_sport;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pjt_tournois_e_sport.AppSpring;
import pjt_tournois_e_sport.config.AppConfig;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBeanFactory().createBean(AppSpring.class).run(args);
		ctx.close();
	}
}
