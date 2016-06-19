package oleg.diplom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ProjectApplication.class, args);
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		List<Object> beans = new ArrayList<Object>();
		for (String bean : beanNames){
			if (bean.contains("ecurity"))
				try {
					beans.add(ctx.getBean(bean));
				}catch (Exception ex){}
				System.out.println("BEANS:\t" + bean);
		}
		System.out.println(beans.size());
	}
}
