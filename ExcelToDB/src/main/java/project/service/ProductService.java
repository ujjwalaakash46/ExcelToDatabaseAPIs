package project.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import project.dto.ResponseDto;
import project.entities.Product;
import project.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepo;
	

	public ResponseEntity<ResponseDto> excelToDB(MultipartFile file) {

		if (!file.getContentType().equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
			return new ResponseEntity<ResponseDto>(new ResponseDto("Uploaded File is not Excel", null),
					HttpStatus.BAD_REQUEST);

		List<Product> productList = new ArrayList<>();
		try {

			XSSFWorkbook book = new XSSFWorkbook(file.getInputStream());

			// Assuming Sheet1 has the perfect data.
			XSSFSheet sheet = book.cloneSheet(0);

			Iterator<Row> rowIterator = sheet.iterator();

			// skipping header
			rowIterator.next();

			while (rowIterator.hasNext()) {

				Product product = new Product();

				Iterator<Cell> cellIterator = rowIterator.next().cellIterator();
				int cellNum = 0;

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cellNum++) {
					case 0:
						product.setName(cell.getStringCellValue());
						break;
					case 1:
						product.setStock((int) cell.getNumericCellValue());
						break;
					case 2:
						product.setDeal((int) cell.getNumericCellValue());
						break;
					case 3:
						product.setFree((int) cell.getNumericCellValue());
						break;
					case 4:
						product.setMrp(cell.getNumericCellValue());
						break;
					case 5:
						product.setRate(cell.getNumericCellValue());
						break;
					case 6:
						product.setCompany(cell.getStringCellValue());
						break;
					case 7:
						product.setBatch(cell.getStringCellValue());
						break;
					case 8:
						product.setExp((cell.getDateCellValue()));
						break;
					case 9:
						product.setSupplier(cell.getStringCellValue());
						break;
					}
				}
				productList.add(product);

			}
			productRepo.saveAll(productList);
			return new ResponseEntity<ResponseDto>(new ResponseDto("File Uploaded", productList), HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<ResponseDto>(new ResponseDto("Issue while processing the file", null),
					HttpStatus.BAD_REQUEST);
		}
	}

	public Page<Product> getAllProducts(int size, int pageNo) {
		return productRepo.findAll(PageRequest.of(pageNo, size));
	}

	public Page<String> getProductsBySupplier(String supplier, int size, int pageNo) {
		return productRepo.findBySupplierAndExp(supplier, new Date(), PageRequest.of(pageNo, size));
	}

	public Page<String> getProductsBySupplierInstock(String supplier, int size, int pageNo) {
		return productRepo.findBySupplierAndInstock(supplier, PageRequest.of(pageNo, size));
	}

	public Page<Product> getDetailsByname(String name, int size, int pageNo) {
		return productRepo.findByName(name, PageRequest.of(pageNo, size));
	}

}
