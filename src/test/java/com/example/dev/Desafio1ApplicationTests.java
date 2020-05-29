package com.example.dev;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.function.ToLongFunction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.dev.domain.Categoria;
import com.example.dev.domain.Produto;
import com.example.dev.service.CategoriaService;
import com.example.dev.service.ProdutoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class Desafio1ApplicationTests
{

	@Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CategoriaService cat_serv;
    
    @Autowired
    private ProdutoService prod_serv;
    
	@Test
	void case1() throws Exception
	{
		
		//SAVE
		Categoria categoria = new Categoria("Categoria 1");
		
		mockMvc.perform(post("/app/categoria")
		        .contentType("application/json")
		        .content(objectMapper.writeValueAsString(categoria)))
		        .andExpect(status().isOk());
		
		Categoria categoria_return = cat_serv.save_categoria(categoria);
		
		Produto produto = new Produto(categoria_return, "Produto 1");
		
		mockMvc.perform(post("/app/produto")
		        .contentType("application/json")
		        .content(objectMapper.writeValueAsString(produto)))
		        .andExpect(status().isOk());
		
		Produto produto_return = prod_serv.save_produto(produto);
		
		assertThat(produto_return).isEqualTo(produto);
		
		
		//UPDATE
		produto_return.setDescricao("Produto 1 update");
		
		mockMvc.perform(put("/app/produto")
		        .contentType("application/json")
		        .content(objectMapper.writeValueAsString(produto_return)))
		        .andExpect(status().isOk());
		
		Produto produto_return2 = prod_serv.update_produto(produto_return);
		
		assertThat(produto_return.getDescricao()).isEqualTo(produto_return2.getDescricao());
		
		
		//GET ALL
		MvcResult res = (MvcResult) mockMvc.perform(get("/app/produto")
		        .contentType("application/json"))
		        .andExpect(status().isOk()).andReturn();
		
		String test = res.getResponse().getContentAsString();
		
		System.out.println(test);
		
		Produto produto_get = prod_serv.get_produto(produto_return2.getId());
		assertThat(produto_get.getId()).isEqualTo(produto_return2.getId());
		
		
		//GET BY ID
		MvcResult res2 = (MvcResult) mockMvc.perform(MockMvcRequestBuilders
	            .get("/app/produto/29", produto_return2.getId())
	            .contentType("application/json")
		        .content(objectMapper.writeValueAsString(produto_return)))
	            .andExpect(status().isOk()).andReturn();

		String test2 = res2.getResponse().getContentAsString();
		System.out.println(test2);
		
		
		//DELETE
		mockMvc.perform(MockMvcRequestBuilders
	            .delete("/app/produto/{id}", produto_return2.getId())
	            .contentType(MediaType.APPLICATION_JSON)
	            .accept(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk());
	}
	
}
