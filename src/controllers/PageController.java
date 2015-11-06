package controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sendgrid.SendGrid;
import com.sendgrid.SendGrid.Email;
import com.sendgrid.SendGridException;

import dto.Form;

@Controller
public class PageController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getIndexPage() {
		System.out.println("getIndexPage called");
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public ModelAndView submitForm(@Valid @ModelAttribute("form") Form form, BindingResult result) {
		System.out.println("submitForm called");
		
		if (result.hasErrors()) {
			return new ModelAndView("index");
		}
		System.out.println(form);

		SendGrid sendgrid = new SendGrid(System.getenv("SENDGRID_USERNAME"), System.getenv("SENDGRID_PASSWORD"));
		
		Email email = new Email();
		email.addTo("peter.rangelov11@gmail.com");
		email.setFrom("do-not-reply@treover.com");
		email.setSubject("New repair request from " + form.getName());
		
		try {
			email.addAttachment(form.getFile().getOriginalFilename(), form.getAsFile());
		} catch (FileNotFoundException nfe) {
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			byte[] encoded = Files.readAllBytes(Paths.get("C:/Users/prangelov/workspace/Treover/WebContent/WEB-INF/table_template.html"));
			String html = String.format(new String(encoded), form.getName(), form.getUnit(), form.getSubject(), form.getText());
			email.setHtml(html);
			SendGrid.Response response = sendgrid.send(email);
			System.out.println(response.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SendGridException e) {
			System.err.println(e);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		ModelAndView m = new ModelAndView("thank_you");
		m.addObject("form", form);
		return m;
	}

}
