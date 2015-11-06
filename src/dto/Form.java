package dto;

import java.io.File;
import java.io.IOException;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Form {
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String unit;
	
	@NotEmpty
	private String subject;
	
	@NotEmpty
	private String text;
	
	private MultipartFile file;

	public File getAsFile() throws IllegalStateException, IOException {
		File convFile = new File(file.getOriginalFilename());
		file.transferTo(convFile);
		return convFile;
	}
}
