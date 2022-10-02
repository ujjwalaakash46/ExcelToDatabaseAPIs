package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import project.dto.ResponseDto;
import project.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	/**
	 * 
	 * @param file: xlsx file
	 * @return list of product added from the file.
	 * 
	 *         url: http://localhost:8080/upload? and add file
	 */
	@PostMapping("/upload")
	public ResponseEntity<ResponseDto> uploadExcel(@RequestParam("file") MultipartFile file) {
		return productService.excelToDB(file);
	}

	/**
	 * 
	 * @param size: size of the page
	 * @param page: page number
	 * @return List of the product with pagination
	 * 
	 *         url: http://localhost:8080/productList?size=10&page=0
	 * 
	 */
	@GetMapping("/productList")
	public ResponseEntity<ResponseDto> getAllProducts(@RequestParam("size") int size, @RequestParam("page") int page) {
		ResponseDto responseDto = new ResponseDto("List: ", productService.getAllProducts(size, page));
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}

	/**
	 * 
	 * @param supplier: supplier(not to be exact)
	 * @param size:     size of the page
	 * @param page:     page number
	 * @return List of product by supplier which isn't expire.
	 * 
	 *         url: http://localhost:8080/productList/TRINETRA PHARMA
	 *         HYDERABAD?size=10&page=0
	 */
	@GetMapping("/productList/{supplier}")
	public ResponseEntity<ResponseDto> getProductBySupplier(@PathVariable("supplier") String supplier,
			@RequestParam("size") int size, @RequestParam("page") int page) {
		ResponseDto responseDto = new ResponseDto("Product Name by supplier and expire: ",
				productService.getProductsBySupplier(supplier, size, page));
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}

	/**
	 * 
	 * @param supplier: supplier(not to be exact)
	 * @param size:     size of the page
	 * @param page:     page number
	 * @return List of product by supplier which has stock.
	 * 
	 *         url: http://localhost:8080/productList/instock/TRINETRA PHARMA
	 *         HYDERABAD?size=10&page=0
	 */
	@GetMapping("/productList/instock/{supplier}")
	public ResponseEntity<ResponseDto> getProductBySupplierInstock(@PathVariable("supplier") String supplier,
			@RequestParam("size") int size, @RequestParam("page") int page) {
		ResponseDto responseDto = new ResponseDto("Product Name by supplier and instock: ",
				productService.getProductsBySupplierInstock(supplier, size, page));
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}

	/**
	 * 
	 * @param name: exact name
	 * @param size: size of the page
	 * @param page: page number
	 * @return details of product by name.
	 * 
	 *         url: http://localhost:8080/details/1-AL 5MG TABS ***?size=10&page=0
	 */
	@GetMapping("/details/{name}")
	public ResponseEntity<ResponseDto> getDetailsByname(@PathVariable("name") String name,
			@RequestParam("size") int size, @RequestParam("page") int page) {
		ResponseDto responseDto = new ResponseDto("Details of Product: ",
				productService.getDetailsByname(name, size, page));
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
}
