package br.iftm.prova3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProgLoja extends Application implements EventHandler{
	Button btnCadastrar, btnBuscar, btnExcluir, btnCadastrarCd, btnCadastrarDvd, btnCadastrarCelular, btnCadastrarJogo,
	btnCadastrarLivro, btnSalvar;
	Button btnBuscarLivro, btnBuscarJogo, btnBuscarCelular, btnBuscarDvd, btnBuscarCd;
	Button btnExcluirLivro, btnExcluirJogo, btnExcluirCelular, btnExcluirDvd, btnExcluirCd;
	
	public static void main(String[] args) 
	{
		launch();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage palco) throws Exception 
	{
		HBox raiz = new HBox(10);
		raiz.setAlignment(Pos.CENTER);
		
		btnCadastrar = new Button("Cadastrar");
		btnBuscar = new Button("Buscar");
		btnExcluir = new Button("Excluir");
		
		btnCadastrar.setOnAction(this);
		btnBuscar.setOnAction(this);
		btnExcluir.setOnAction(this);
		
		raiz.getChildren().addAll(btnCadastrar,btnBuscar,btnExcluir);
		
		Scene cena = new Scene(raiz, 250, 100);
		
		palco.setTitle("Prova 3");
		palco.setScene(cena);
		palco.show();
	}

	@Override
	public void handle(Event evento) 
	{
		if(evento.getSource().equals(btnCadastrar))
		{
			cadastrar();
		}
		else if (evento.getSource().equals(btnBuscar))
		{
			buscar();
		}
		else
		{
			excluir();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void cadastrar()
	{
		VBox raiz = new VBox(10);
		raiz.setAlignment(Pos.CENTER);
		btnCadastrarCd = new Button("Cadastrar CD");
		btnCadastrarCd.setOnAction(new EventHandler() 
		{

			@Override
			public void handle(Event event) 
			{
				VBox raiz = new VBox(); 
				raiz.setAlignment(Pos.CENTER);
				
				Label Informacao = new Label("Preencha as informações CD");
				
				TextField nome = new TextField("Informe o nome do Cd");
				TextField preco = new TextField("Informe o preço do Cd");
				TextField faixas = new TextField("Informe a quantidade de faixas do Cd");
				
				Button btnSalvar = new Button("Salvar Cd");
				
				raiz.getChildren().addAll(Informacao, nome, preco, faixas, btnSalvar);
				
				Scene cena = new Scene(raiz, 400, 300);
				Stage palco = new Stage();
				palco.setTitle("Cadastro de CD");
				palco.setScene(cena);
				palco.show();
				
				btnSalvar.setOnAction(new EventHandler() 
				{
					@Override
					public void handle(Event evento) 
					{
						Cds c = new Cds();
						c.setNome(nome.getText());
						c.setPreco(Integer.parseInt(preco.getText()));
						c.setQtd_faixas(Integer.parseInt(faixas.getText()));
						
						DBConnection.getInstance().getEm().getTransaction().begin();
						DBConnection.getInstance().getEm().persist(c);
						DBConnection.getInstance().getEm().getTransaction().commit();
					}
				
				});
				
			}
			
		});
		
		btnCadastrarDvd = new Button("Cadastrar DVD");
		btnCadastrarDvd.setOnAction(new EventHandler() 

		{

			@Override
			public void handle(Event event) 
			{
				VBox raiz = new VBox(); 
				raiz.setAlignment(Pos.CENTER);
				
				Label informacao = new Label("Preencha as informações do Dvd");
				
				TextField nome = new TextField("Informe o nome do Dvd");
				TextField preco = new TextField("Informe o preço do Dvd");
				TextField duracao = new TextField("Informe a duração do Dvd");
				
				Button btnSalvar = new Button("Salvar Dvd");
				
				raiz.getChildren().addAll(informacao, nome, preco, duracao, btnSalvar);
				
				Scene cena = new Scene(raiz, 400, 300);
				Stage palco = new Stage();
				palco.setTitle("Cadastro de DVD");
				palco.setScene(cena);
				palco.show();
				
				btnSalvar.setOnAction(new EventHandler() 
				{
					@Override
					public void handle(Event evento) 
					{
						Dvds d = new Dvds();
						d.setNome(nome.getText());
						d.setPreco(Integer.parseInt(preco.getText()));
						d.setDuracao(Integer.parseInt(duracao.getText()));
						
						DBConnection.getInstance().getEm().getTransaction().begin();
						DBConnection.getInstance().getEm().persist(d);
						DBConnection.getInstance().getEm().getTransaction().commit();
					}
				
				});
				
			}
			
		});
		
		btnCadastrarCelular = new Button("Cadastrar CELULAR");
		btnCadastrarCelular.setOnAction(new EventHandler() 
		{

			@Override
			public void handle(Event event) 
			{
				VBox raiz = new VBox(); 
				raiz.setAlignment(Pos.CENTER);
				
				Label informacao = new Label("Preencha as informações do Celular");
				
				TextField nome = new TextField("Informe o nome do Celular");
				TextField preco = new TextField("Informe o preço do Celular");
				TextField fabricante = new TextField("Informe o fabricante do Celular");
				
				Button btnSalvar = new Button("Salvar Celular");
				
				raiz.getChildren().addAll(informacao, nome, preco, fabricante, btnSalvar);
				
				Scene cena = new Scene(raiz, 400, 300);
				Stage palco = new Stage();
				palco.setTitle("Cadastro de Celular");
				palco.setScene(cena);
				palco.show();
				
				btnSalvar.setOnAction(new EventHandler() 
				{
					@Override
					public void handle(Event evento) 
					{
						Celular c = new Celular();
						c.setNome(nome.getText());
						c.setPreco(Integer.parseInt(preco.getText()));
						c.setFabricante(fabricante.getText());
						
						DBConnection.getInstance().getEm().getTransaction().begin();
						DBConnection.getInstance().getEm().persist(c);
						DBConnection.getInstance().getEm().getTransaction().commit();
					}
				
				});
				
			}
			
		});
		
		btnCadastrarJogo = new Button("Cadastrar JOGO");
		btnCadastrarJogo.setOnAction(new EventHandler() 
		{

			@Override
			public void handle(Event event) 
			{
				VBox raiz = new VBox(); 
				raiz.setAlignment(Pos.CENTER);
				
				Label informacao = new Label("Preencha as informações do JOGO");
				
				TextField nome = new TextField("Informe o nome do JOGO");
				TextField preco = new TextField("Informe o preço do JOGO");
				TextField genero = new TextField("Informe o genero do JOGO");
				
				Button btnSalvar = new Button("Salvar JOGO");
				
				raiz.getChildren().addAll(informacao, nome, preco, genero, btnSalvar);
				
				Scene cena = new Scene(raiz, 400, 300);
				Stage palco = new Stage();
				palco.setTitle("Cadastro de JOGO");
				palco.setScene(cena);
				palco.show();
				
				btnSalvar.setOnAction(new EventHandler() 
				{
					@Override
					public void handle(Event evento) 
					{
						Jogos j = new Jogos();
						j.setNome(nome.getText());
						j.setPreco(Integer.parseInt(preco.getText()));
						j.setGenero(genero.getText());
						
						DBConnection.getInstance().getEm().getTransaction().begin();
						DBConnection.getInstance().getEm().persist(j);
						DBConnection.getInstance().getEm().getTransaction().commit();
					}
				});
			}
			
		});
		
		btnCadastrarLivro= new Button("Cadastrar LIVRO");
		btnCadastrarLivro.setOnAction(new EventHandler() 
		{

			@Override
			public void handle(Event event) 
			{
				VBox raiz = new VBox(); 
				raiz.setAlignment(Pos.CENTER);
				
				Label informacao = new Label("Preencha as informações do LIVRO");
				
				TextField nome = new TextField("Informe o nome do LIVRO");
				TextField preco = new TextField("Informe o preço do LIVRO");
				TextField autor = new TextField("Informe o autor do LIVRO");
				
				Button btnSalvar = new Button("Salvar LIVRO");
				
				raiz.getChildren().addAll(informacao, nome, preco, autor, btnSalvar);
				
				Scene cena = new Scene(raiz, 400, 300);
				Stage palco = new Stage();
				palco.setTitle("Cadastro de LIVRO");
				palco.setScene(cena);
				palco.show();
				
				btnSalvar.setOnAction(new EventHandler() 
				{
					@Override
					public void handle(Event evento) 
					{
						Livros l = new Livros();
						l.setNome(nome.getText());
						l.setPreco(Integer.parseInt(preco.getText()));
						l.setAutor(autor.getText());
						
						DBConnection.getInstance().getEm().getTransaction().begin();
						DBConnection.getInstance().getEm().persist(l);
						DBConnection.getInstance().getEm().getTransaction().commit();
					}
				});
			}
			
		});
		

		raiz.getChildren().addAll(btnCadastrarCd,btnCadastrarDvd,btnCadastrarCelular,btnCadastrarJogo,btnCadastrarLivro);
		
		Scene cena = new Scene(raiz, 300, 200);
		Stage palco = new Stage();
		palco.setTitle("Opções de Cadastro");
		palco.setScene(cena);
		palco.show();
	}
	
	@SuppressWarnings("unchecked")
	public void buscar()
	{
		VBox raiz = new VBox(10);
		raiz.setAlignment(Pos.CENTER);
		
		btnBuscarLivro = new Button("Buscar LIVRO");
		btnBuscarLivro.setOnAction(new EventHandler() 
		{

			@Override
			public void handle(Event event) 
			{
				VBox raiz = new VBox(10);
				raiz.setAlignment(Pos.CENTER);
				
				Label informacao = new Label("Buscar Livro Por ID");
				
				TextField id = new TextField("Informe o ID"); 
				
				Button Buscar = new Button("Realizar BUSCA");
				
			
				Buscar.setOnAction(new EventHandler() 
				{

					@Override
					public void handle(Event event) 
					{
						try 
						{
							Livros l = DBConnection.getInstance().getEm().find(Livros.class, id);
							Label achou = new Label(l.getNome()+ l.getAutor()+l.getPreco());
							raiz.getChildren().add(achou);
						} catch (Exception e) {
							Label achou= new Label("Livro não encontrado");
							raiz.getChildren().add(achou);
						}
						
						
					}
				});
				raiz.getChildren().addAll(informacao,id,Buscar);
				Scene cena = new Scene(raiz, 300, 200);
				Stage palco = new Stage();
				palco.setTitle("Busca de LIVRO");
				palco.setScene(cena);
				palco.show();
				
			}
		});
		

		btnBuscarJogo = new Button("Buscar JOGO");
		btnBuscarJogo.setOnAction(new EventHandler() 
		{

			@Override
			public void handle(Event event) 
			{
				VBox raiz = new VBox(10);
				raiz.setAlignment(Pos.CENTER);
				
				Label informacao = new Label("Buscar jogo Por ID");
				
				TextField id = new TextField("Informe o ID"); 
				
				Button Buscar = new Button("Realizar BUSCA");
				
				raiz.getChildren().addAll(informacao,id,Buscar);
				Scene cena = new Scene(raiz, 300, 200);
				Stage palco = new Stage();
				palco.setTitle("Busca de JOGO");
				palco.setScene(cena);
				palco.show();
				
				Buscar.setOnAction(new EventHandler() 
				{

					@Override
					public void handle(Event event) 
					{	
						try 
						{
							Jogos j = DBConnection.getInstance().getEm().find(Jogos.class, id);
							Label achou = new Label(j.getNome()+ j.getGenero()+j.getPreco());
							raiz.getChildren().add(achou);
						} catch (Exception e) {
							Label achou= new Label("Jogo não encontrado");
							raiz.getChildren().add(achou);
						}
					}
				});
			}
		});
		
		btnBuscarCelular = new Button("Buscar CELULAR");
		btnBuscarCelular.setOnAction(new EventHandler() 
		{

			@Override
			public void handle(Event event) 
			{
				VBox raiz = new VBox(10);
				raiz.setAlignment(Pos.CENTER);
				
				Label informacao = new Label("Buscar Celular Por ID");
				
				TextField id = new TextField("Informe o ID"); 
				
				Button Buscar = new Button("Realizar BUSCA");
				
				raiz.getChildren().addAll(informacao,id,Buscar);
				Scene cena = new Scene(raiz, 300, 200);
				Stage palco = new Stage();
				palco.setTitle("Busca de CELULAR");
				palco.setScene(cena);
				palco.show();
				
				Buscar.setOnAction(new EventHandler() 
				{

					@Override
					public void handle(Event event) 
					{
						try 
						{
							Celular c = DBConnection.getInstance().getEm().find(Celular.class, id);
							Label achou = new Label(c.getNome()+ c.getFabricante()+c.getPreco());
							raiz.getChildren().add(achou);
						} catch (Exception e) {
							Label achou= new Label("Celular não encontrado");
							raiz.getChildren().add(achou);
						}						
					}
				});
			}
		});
		
		btnBuscarDvd = new Button("Buscar DVD");
		btnBuscarDvd.setOnAction(new EventHandler() 
		{

			@Override
			public void handle(Event event) 
			{
				VBox raiz = new VBox(10);
				raiz.setAlignment(Pos.CENTER);
				
				Label informacao = new Label("Buscar DVD Por ID");
				
				TextField id = new TextField("Informe o ID"); 
				
				Button Buscar = new Button("Realizar BUSCA");
				
				raiz.getChildren().addAll(informacao,id,Buscar);
				Scene cena = new Scene(raiz, 300, 200);
				Stage palco = new Stage();
				palco.setTitle("Busca de CELULAR");
				palco.setScene(cena);
				palco.show();
				
				Buscar.setOnAction(new EventHandler() 
				{

					@Override
					public void handle(Event event) 
					{
						try 
						{
							Dvds d = DBConnection.getInstance().getEm().find(Dvds.class, id);
							Label achou = new Label(d.getNome()+ d.getDuracao()+d.getPreco());
							raiz.getChildren().add(achou);
						} catch (Exception e) {
							Label achou= new Label("Dvd não encontrado");
							raiz.getChildren().add(achou);
						}						
					}
				});
			}
		});

		btnBuscarCd= new Button("Buscar CD");
		btnBuscarCd.setOnAction(new EventHandler() 
		{

			@Override
			public void handle(Event event) 
			{
				VBox raiz = new VBox(10);
				raiz.setAlignment(Pos.CENTER);
				
				Label informacao = new Label("Buscar CD Por ID");
				
				TextField id = new TextField("Informe o ID"); 
				
				Button Buscar = new Button("Realizar BUSCA");
				
				raiz.getChildren().addAll(informacao,id,Buscar);
				Scene cena = new Scene(raiz, 300, 200);
				Stage palco = new Stage();
				palco.setTitle("Busca de CELULAR");
				palco.setScene(cena);
				palco.show();
				
				Buscar.setOnAction(new EventHandler() 
				{

					@Override
					public void handle(Event event) 
					{
						try 
						{
							Cds c = DBConnection.getInstance().getEm().find(Cds.class, id);
							Label achou = new Label(c.getNome()+ c.getQtd_faixas()+c.getPreco());
							raiz.getChildren().add(achou);
						} catch (Exception e) {
							Label achou= new Label("Cd não encontrado");
							raiz.getChildren().add(achou);
						}								
					}
				});
			}
		});
		
		raiz.getChildren().addAll(btnBuscarLivro,btnBuscarJogo,btnBuscarCelular,btnBuscarDvd,btnBuscarCd);
		
		Scene cena = new Scene(raiz, 300, 200);
		Stage palco = new Stage();
		palco.setTitle("Opções de Busca");
		palco.setScene(cena);
		palco.show();
	}
	
	@SuppressWarnings("unchecked")
	public void excluir()
	{
		VBox raiz = new VBox(10);
		raiz.setAlignment(Pos.CENTER);
		
		btnExcluirLivro = new Button("Excluir LIVRO");
		btnExcluirLivro.setOnAction(new EventHandler() 
		{

			@Override
			public void handle(Event event) 
			{
				VBox raiz = new VBox(10);
				raiz.setAlignment(Pos.CENTER);
				
				Label informacao = new Label("Excluir LIVRO");
				
				TextField id = new TextField("Informe o ID"); 
				
				Button Excluir = new Button("EXCLUIR");
				
				raiz.getChildren().addAll(informacao,id,Excluir);
				Scene cena = new Scene(raiz, 300, 200);
				Stage palco = new Stage();
				palco.setTitle("Exclusão de LIVRO");
				palco.setScene(cena);
				palco.show();
				
				Excluir.setOnAction(new EventHandler() 
				{

					@Override
					public void handle(Event event) 
					{
						Livros l = DBConnection.getInstance().getEm().find(Livros.class, id);

						DBConnection.getInstance().getEm().getTransaction().begin();
						DBConnection.getInstance().getEm().remove(l);
						DBConnection.getInstance().getEm().getTransaction().commit();
					}
				});
			}
		});
		
		btnExcluirJogo = new Button("Excluir JOGO");
		btnExcluirJogo.setOnAction(new EventHandler() 
		{

			@Override
			public void handle(Event event) 
			{
				VBox raiz = new VBox(10);
				raiz.setAlignment(Pos.CENTER);
				
				Label informacao = new Label("Excluir JOGO");
				
				TextField id = new TextField("Informe o ID"); 
				
				Button Excluir = new Button("EXCLUIR");
				
				raiz.getChildren().addAll(informacao,id,Excluir);
				Scene cena = new Scene(raiz, 300, 200);
				Stage palco = new Stage();
				palco.setTitle("Exclusão de JOGO");
				palco.setScene(cena);
				palco.show();
				
				Excluir.setOnAction(new EventHandler() 
				{

					@Override
					public void handle(Event event) 
					{
						Jogos j = DBConnection.getInstance().getEm().find(Jogos.class, id);

						DBConnection.getInstance().getEm().getTransaction().begin();
						DBConnection.getInstance().getEm().remove(j);
						DBConnection.getInstance().getEm().getTransaction().commit();
					}
				});
			}
		});
		
		btnExcluirDvd = new Button("Excluir DVD");
		btnExcluirDvd.setOnAction(new EventHandler() 
		{

			@Override
			public void handle(Event event) 
			{
				VBox raiz = new VBox(10);
				raiz.setAlignment(Pos.CENTER);
				
				Label informacao = new Label("Excluir DVD");
				
				TextField id = new TextField("Informe o ID"); 
				
				Button Excluir = new Button("EXCLUIR");
				
				raiz.getChildren().addAll(informacao,id,Excluir);
				Scene cena = new Scene(raiz, 300, 200);
				Stage palco = new Stage();
				palco.setTitle("Exclusão de DVD");
				palco.setScene(cena);
				palco.show();
				
				Excluir.setOnAction(new EventHandler() 
				{

					@Override
					public void handle(Event event) 
					{
						Dvds d = DBConnection.getInstance().getEm().find(Dvds.class, id);

						DBConnection.getInstance().getEm().getTransaction().begin();
						DBConnection.getInstance().getEm().remove(d);
						DBConnection.getInstance().getEm().getTransaction().commit();
					}
				});
			}
		});
		
		btnExcluirCd = new Button("Excluir CD");
		btnExcluirCd.setOnAction(new EventHandler() 
		{

			@Override
			public void handle(Event event) 
			{
				VBox raiz = new VBox(10);
				raiz.setAlignment(Pos.CENTER);
				
				Label informacao = new Label("Excluir CD");
				
				TextField id = new TextField("Informe o ID"); 
				
				Button Excluir = new Button("EXCLUIR");
				
				raiz.getChildren().addAll(informacao,id,Excluir);
				Scene cena = new Scene(raiz, 300, 200);
				Stage palco = new Stage();
				palco.setTitle("Exclusão de CD");
				palco.setScene(cena);
				palco.show();
				
				Excluir.setOnAction(new EventHandler() 
				{

					@Override
					public void handle(Event event) 
					{
						Cds cd = DBConnection.getInstance().getEm().find(Cds.class, id);

						DBConnection.getInstance().getEm().getTransaction().begin();
						DBConnection.getInstance().getEm().remove(cd);
						DBConnection.getInstance().getEm().getTransaction().commit();
					}
				});
			}
		});
		
		btnExcluirCelular = new Button("Excluir CELULAR");
		btnExcluirCelular.setOnAction(new EventHandler() 
		{

			@Override
			public void handle(Event event) 
			{
				VBox raiz = new VBox(10);
				raiz.setAlignment(Pos.CENTER);
				
				Label informacao = new Label("Excluir CELULAR");
				
				TextField id = new TextField("Informe o ID"); 
				
				Button Excluir = new Button("EXCLUIR");
				
				raiz.getChildren().addAll(informacao,id,Excluir);
				Scene cena = new Scene(raiz, 300, 200);
				Stage palco = new Stage();
				palco.setTitle("Exclusão de CELULAR");
				palco.setScene(cena);
				palco.show();
				
				Excluir.setOnAction(new EventHandler() 
				{

					@Override
					public void handle(Event event) 
					{
						Celular c = DBConnection.getInstance().getEm().find(Celular.class, id);

						DBConnection.getInstance().getEm().getTransaction().begin();
						DBConnection.getInstance().getEm().remove(c);
						DBConnection.getInstance().getEm().getTransaction().commit();
					}
				});
			}
		});
		raiz.getChildren().addAll(btnExcluirLivro,btnExcluirJogo,btnExcluirDvd,btnExcluirCd,btnExcluirCelular);
		
		Scene cena = new Scene(raiz, 300, 200);
		Stage palco = new Stage();
		palco.setTitle("Opções de Exclusão");
		palco.setScene(cena);
		palco.show();

	}
	
}
	
