package com.myshopping.MYShopping.service;

import com.myshopping.MYShopping.dto.ProductDTO;
import com.myshopping.MYShopping.exception.ResourceNotFound;
import com.myshopping.MYShopping.exception.UnAuthorized;
import com.myshopping.MYShopping.models.AppUser;
import com.myshopping.MYShopping.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myshopping.MYShopping.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserService userService;

   public Product getProductById(UUID id){
       return productRepository.findById(id).orElse(null);
   }
    public void registerProduct(Product product, UUID sellerId){
        AppUser user=userService.getUserById(sellerId);
        if(user==null){
            throw new ResourceNotFound(String.format("Seller with sellerId %s does not exist in system.",sellerId.toString()));
        }
        if(!user.getUserType().equals("SELLER")){
            throw new UnAuthorized(String.format("User with id %s does not have access to perform this action"));
        }
        product.setUser(user);
        productRepository.save(product) ;
    }

    public void updateProductQuantity(UUID productID,int quantity){
       productRepository.updateProductQuantity(productID,quantity);
    }

    public List<ProductDTO>convertProductToProductDTO(List<Product>products){
        List<ProductDTO>productList = new ArrayList<>();
        for(Product product: products){
            ProductDTO productDTO=new ProductDTO();
            ProductDTO.setProductName(product.getName());
            ProductDTO.setProductCategory(product.getCategory());
            ProductDTO.setId(product.getId());
            ProductDTO.setPrice(product.getPrice());
            ProductDTO.setDescription(product.getDescription());
            ProductDTO.setRating(product.getRating());
            productList.add(productDTO);

        }
        return productList;
    }
    public List<ProductDTO> searchByProductName( String productName){
        List<Product>products= productRepository.getProductsByName(productName);
        List<ProductDTO>productList=convertProductToProductDTO(products);
        return productList;
    }
    public List<ProductDTO> searchByCategory(String category){
        List<Product>products= productRepository.getProductsByCategory(category);
        List<ProductDTO>productList=convertProductToProductDTO(products);
        return productList;
    }
    public List<ProductDTO> searchByCategoryAndProductName(String productName, String category){
        List<Product>products= productRepository.getProductsByCategoryAndName(category,productName);
        List<ProductDTO>productList=convertProductToProductDTO(products);
        return productList;
    }
    public List<ProductDTO> getAllProducts(){
        List<Product>products= productRepository.findAll();
        List<ProductDTO>productList=convertProductToProductDTO(products);
        return productList;
    }
}
