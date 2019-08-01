/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import Historial.HistorialFotografia;
import Producto.Producto;
import RegistroRiego.RegistroRiego;
import TipoProducto.TipoProducto;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import java.io.File;
import java.sql.Date;
import java.time.LocalDate;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.DatePicker;

import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;


/**
 *
 * @author SAINZ
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private AnchorPane ventana_inicio,ventana_menu,ventana_agregarTipo,ventana_agregarProducto,ventana_registroRiego,ventana_registroHistorial,ventana_presentacion;
    
    @FXML
    private Label label;
    @FXML
    private Button btnIngresar;
    @FXML
    private Button btnMenu;
    @FXML
    private Button btnPresentacion;
               
    @FXML
    private ComboBox combo=new ComboBox();
    
    @FXML
    private Tab btnHF; //Historial de Fotografia
    
    @FXML
    private TableView<HistorialFotografia> tablaHistorial; //Lista de Historial de Fotografia
    
    @FXML
    private TableColumn<HistorialFotografia, String> txtIdHistorial; // Columna 1
    
    @FXML
    private TableColumn<HistorialFotografia, String> txtFechaHistorial; // Columna 2
       
    @FXML
    private TableColumn<HistorialFotografia, String> txtUrlHistorial; // Columna 3
    
     
    ObservableList<HistorialFotografia> dataHF = FXCollections.observableArrayList();
    
    //---- Elemento * * * 
    @FXML
    private DatePicker textDateHistorial;
    @FXML
    private TextField urlHistorial; 
    @FXML
    private ImageView imagen;
    @FXML
    private Button btnSeleccionarImagen;
    @FXML 
    private Button btnEditarH,btnEditarHistorial,btnEditarHistorialContinuar,btnEliminarH,btnEliminarHistorial;
    @FXML
    private TextField txtIdHistorialFoto;
   @FXML
    private Button btnlistH; //Agregando Historial de Fotografia
   //------------------------------------------------------------------------------------
    private int posicionTipoProducto;
   
   @FXML
    private Tab btnTP; //Tipo de Productos
    
    @FXML
    private TableView<TipoProducto> tablaTipoProducto; //Tabla general
    
    @FXML
    private TableColumn<TipoProducto, String> txtIdTP; // Columna 1
     
    @FXML
    private TableColumn<TipoProducto, String> txtTP; // Columna 2
    
    ObservableList<TipoProducto> dataTP = FXCollections.observableArrayList();
    
    // Elementos * * * 
    @FXML
    private TextField txtTipo;
    
    @FXML
    private Button btnlistT; //Agregando Tipo de Producto
    
        
    //-----------------------------------------------------------------------------------
    @FXML
    private Tab btnP; //Producto
     
    @FXML
    private TableView<Producto> tablaProducto; //Lista de Producto
    
    @FXML
    private TableColumn<Producto, String> txtIdP; // Columna 1
 
    @FXML
    private TableColumn<Producto, String> txtNombre; // Columna 2
    
    @FXML
    private TableColumn<Producto, String> txtTipoProducto; // Columna 3
    
    @FXML
    private TableColumn<Producto, String> txtCondicionActual; // Columna 4
    
    @FXML
    private TableColumn<Producto, String> txtFechaIngreso; // Columna 5 
    
    ObservableList<Producto> dataP = FXCollections.observableArrayList();
    
    // Elementos * * *
    @FXML
    private ComboBox combo1 = new ComboBox();
    
    @FXML
    private TextField textNombreP;
    
    @FXML
    private TextField textTipoProducto;
    
    @FXML
    private TextField textCondicionP;
    
    @FXML
    private DatePicker textFechaP;
    
    @FXML
    private Button btnlistP; //Agregando Producto
   
    //-------------------------------   ----------------------------------------------------
    @FXML
    private Tab btnRR; //Registro de Riego
    
    @FXML
    private TableView<RegistroRiego> tablaRegistroRiego; //Tabla General
    
    @FXML
    private TableColumn<RegistroRiego, String> txtIdRiego; // Columna 1
    
    @FXML
    private TableColumn<RegistroRiego, String> txtFechaRegistro; // Columna 2
    @FXML
    private TableColumn<RegistroRiego, String> txtProducto; // Columna 3
        
    ObservableList<RegistroRiego> dataRR = FXCollections.observableArrayList();
    
    //----- Elementos * * * 
    @FXML
    private DatePicker textDataRiego;
    
    @FXML
    private ComboBox combo2 = new ComboBox();
    
    @FXML
    private TextField txtIdRegistroRiego;
            
    @FXML
    private Button btnlistRR; //Agregando Registro de Riego
    @FXML
    private Button btnEditarRiego,btnEliminarRiego,btnEditarRiegoContinuar,btnEliminarRiegoContinuar,btnEditarContinuarRiego,btnAgregarR; 
    //------------------------------------------------------------------------------------
    @FXML
    private Tab btnCerrarSesion; //Cerrar Session
    
    //Elementos * * *
     @FXML
    private TextField textuser;
    
    @FXML
    private PasswordField textpassword;
    //------------------------------------------------------------------------------------
    @FXML
    private Tab btnReportes; //Reportes de Grafica
    
    @FXML
    private Button btnReporteTP; //Reporte de Tipo de Producto
    
    @FXML
    private Button btnReporteP; //Reporte de Producto
    
    @FXML
    private Button btnReporteCS; //Reporte de Calendario Semanal
    
    @FXML
    private Button btnReporteRR; //Reporte de Registro de Riego
       
    @FXML
    private Button btnReporteHF; //Reporte de Historial de Fotografia
    
    //------------------------------------- Elementos de crear ------------------------------------- 
    
    @FXML
    private Button btnAgregarTipoProducto;
    @FXML
    private Button btnEliminarCon;
    @FXML
    private TextField txtIdEliminar;
    @FXML
    private Button btnEditarTipo;
    @FXML
    private TextField txtIdEditar;
    @FXML
    private Button btnEditarContinuar;
    @FXML
    private Button btnEditarProducto;
    @FXML
    private Button btnEliminarProducto;
    @FXML
    private TextField txtIdProducto;
    @FXML
    private Button btnEditarProductoContinuar;
    @FXML
    private Button btnAgregarTipo;
    @FXML
    private Button btnAgregarProducto;
    @FXML
    private Button btnAgregarP;
    @FXML
    private Button btnAgregarHistorial;
    @FXML
    private Button btnAgregarRiego;
    @FXML
    private Button btnCerrar;
    @FXML
    private ImageView imgReportes; //imagen de Reportes
    //---------------------------------Video------------------------------------------------------------
    Media me;
    MediaPlayer mp;
    @FXML
    private MediaView video;
    @FXML
    private Button btnReproducirAction;
    @FXML
    private Button btnDetener;
    @FXML
    private Button btnPausar;
    @FXML
    private Button btnRegresarInicio;
    
    
    //--------------------------------- Conexiones de Manejadores ---------------------------------------
    Connection conexionBDMysql = null;
    Connection conexionBDSQL;
    Connection verificar = null; // Parte de Login
    Connection conexion = null;
    Connection conexion1=null;
    Connection connection = null;
    PreparedStatement preparedStatement = null; // Parte de Login
    ResultSet resultSet = null;
    //private String urlMysql="jdbc:mysql://localhost/jardineria",username="root",password="slmca";
   // private String urlSqlServer="jdbc:sqlserver:1433",databaseName="jardineria",user="moisesdario",pass="171148";
    //----
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML
    private void btnIngresarAction(ActionEvent event) throws IOException{
        String usuarios = textuser.getText().toString();
        String password = textpassword.getText().toString();
        
        //Date picker
        String manejador= (String) combo.getSelectionModel().getSelectedItem();
        
        if(manejador.equals("MySQL")){
            verificar=null;
            verificar=statusConnectionMySQL();
            String mysql = "SELECT * FROM usuario WHERE usuarios = ? and password = ?";
            try{
              preparedStatement = conexionBDMysql.prepareStatement(mysql);
              preparedStatement.setString(1, usuarios);
              preparedStatement.setString(2, password);
              mostrarTP();
              mostrarP();
              mostrarRR();
              mostrarHF();
              resultSet = preparedStatement.executeQuery();
              if(!resultSet.next()){
                  System.out.println("Por favor entrar correctamente con el Usuario and Password en MYSQL");
                }else{
                  this.ventana_menu.setVisible(true);
                  this.ventana_inicio.setVisible(false);
                  this.btnEliminarCon.setVisible(false);
                  this.txtIdEliminar.setVisible(false);
                  this.btnEditarTipo.setVisible(false);
                  this.txtIdEditar.setVisible(false);
                  //tablaTipoProducto.getSelectionModel().getSelectedItems();
                }
            }
          catch(Exception e){
              e.printStackTrace();
            }
        }
        if(manejador.equals("SQL Server")){
            verificar=null;
            verificar=statusConnectionSQL();
            if(verificar!=null){
                String sqlserver = "SELECT * FROM usuario WHERE usuario = ? and password = ?";
                 try{
                  preparedStatement = statusConnectionSQL().prepareStatement(sqlserver);
                  preparedStatement.setString(1, usuarios);
                  preparedStatement.setString(2, password);
                  mostrarTP();
                  mostrarP();
                  mostrarRR();
                  mostrarHF();
                  resultSet = preparedStatement.executeQuery();
                  if(!resultSet.next()){
                      System.out.println("Por favor entrar correctamente con el Usuario and Password en SQL server");
                    }else{
                      this.ventana_menu.setVisible(true);
                      this.ventana_inicio.setVisible(false);
                    }
                }
              catch(SQLException e){
                  System.out.println("Existe un error en el login");
              }
            }
        }
        
        
    }
    //------------------------------------------------------------------- Video -------------------------------------------------------------------------------
    @FXML
    private void btnPresentacionAction(ActionEvent event){
        this.ventana_inicio.setVisible(false);
        this.ventana_presentacion.setVisible(true);
        File vide=new File("src/view/Presentación-video.mp4");
        me=new Media(vide.toURI().toString());
        mp=new MediaPlayer(me);
        video.setMediaPlayer(mp);
        mp.setAutoPlay(true);
    }
    @FXML
    private void btnRegresarInicio(ActionEvent event){
        this.ventana_presentacion.setVisible(false);
        this.ventana_inicio.setVisible(true);
    }
    
    @FXML
    private void btnReproducirAction(ActionEvent event){
        mp.play();
    }
    
    @FXML
    private void btnDetener(ActionEvent event){
        mp.seek(mp.getTotalDuration());
        mp.stop();
    }
    @FXML
    private void btnPausar(ActionEvent event){
        mp.pause();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lista();
    }
    
    @FXML
    private void handleClose(ActionEvent event){
        System.exit(0);
        //close();
    }
    
    
    private void lista(){
            combo.getItems().addAll("MySQL","SQL Server");
    }
    
    //------------------------------------------------------------- Conexion de My SQL -----------------------------------------------------------------------
    private Connection statusConnectionMySQL(){
        try{
            String urlMysql="jdbc:mysql://localhost:3306/jardineria";
            Class.forName("com.mysql.jdbc.Driver").newInstance();       
            conexionBDMysql=(Connection) DriverManager.getConnection(urlMysql,"root","");
            if(conexionBDMysql != null){
                // System.out.print("Conectado a MySQL");
                return conexionBDMysql;
            } else {
            }
        }catch(Exception e){
            System.out.print(e);
            System.out.print("No esta conectado");
            this.ventana_menu.setVisible(false);
            this.ventana_inicio.setVisible(true);
            return conexionBDMysql;
        }
        return conexionBDMysql;
    }
    
    //---------------------------------------------------------------- Conexion de SQL SERVER -----------------------------------------------------------------
    private Connection statusConnectionSQL(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")/*.newInstance()*/;
            String urlSqlServer="jdbc:sqlserver://localhost:1433;databaseName=jardineria";
            conexionBDSQL=(Connection) DriverManager.getConnection(urlSqlServer,"SAINZ","12345");
            if(conexionBDSQL != null){
                System.out.print("Conectado a SQL Server");
                return conexionBDSQL;
            }
        }catch(Exception e){
            System.out.print("No esta conectado");
            System.out.print(e);
            return conexionBDSQL;
        }
        return conexionBDSQL;
    }
    
    //------------------------------------------------- Elementos para crear una tabla -----------------------------------------------------------------------
    
    @FXML
    private void btnlistTAction() throws IOException{
        this.ventana_agregarTipo.setVisible(true);
        this.ventana_menu.setVisible(false);
        this.btnEditarContinuar.setVisible(false);
    }
    
    @FXML
    private void btnlistPAction() throws IOException, SQLException{
        tablaProducto.getItems().clear();
        this.ventana_agregarProducto.setVisible(true);
        this.ventana_menu.setVisible(false);
        this.btnEditarProductoContinuar.setVisible(false);
       // listaTipo();
        //agregarProducto();
    }
    @FXML
    private void btnlistRRAction() throws IOException{
        this.ventana_registroRiego.setVisible(true);
        this.ventana_menu.setVisible(false);
        this.btnEditarContinuarRiego.setVisible(false);
        //agregarRegistroRiego();
    }
     @FXML
    private void btnlistHAction() throws IOException{
        
        this.ventana_registroHistorial.setVisible(true);
        this.ventana_menu.setVisible(false);
        this.btnEditarHistorialContinuar.setVisible(false);
        this.btnAgregarHistorial.setVisible(true);
        
        
    }
    
    //--------------------------------------------------------- Metodos de crear tipo producto --------------------------------------------------------------------   
    @FXML
    private void btnAgregarTipoProducto(){
        insertTP(); // Insertar
        mostrarTP(); //Mostrar
    }
    
    private void insertTP(){
        String nombreTipo=txtTipo.getText(); 
        almacenarTipoProducto(nombreTipo);
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        if(conexion.equals("MySQL")){
            String mysql="INSERT INTO tipoproducto (tipo) VALUES ('"+nombreTipo+"')";
            try{
                Statement st=conexionBDMysql.createStatement();
                st.executeUpdate(mysql);
                System.out.println("Datos agregado"+mysql);
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);                  
            }
        }
        //---------------------------------------------------       SQL Server      ----------------------------------------------------------------------------
        if(conexion.equals("SQL Server")){
            String sql="INSERT INTO tipoproducto (tipo) VALUES ('"+nombreTipo+"')";
            try{
                Statement st=conexionBDSQL.createStatement();
                st.executeUpdate(sql);
                System.out.println("Datos agregado"+sql);
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);                  
            }
        }
      this.ventana_menu.setVisible(true);
      this.ventana_agregarTipo.setVisible(false);
      
      this.txtTipo.setText(""); 
    }
    //-------------------------------------------------------------------Almacenamiento de Combo Box -------------------------------------------------------------------------------
        public void almacenarTipoProducto(String nombreTipo){
        String guardar = nombreTipo;
        combo1.getItems().addAll(guardar);
        String almacenar= (String) combo1.getSelectionModel().getSelectedItem();
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        if(conexion.equals("MySQL")){          
            conexion1=statusConnectionMySQL();
            try{
                String mysql="Select tipo from tipoproducto" ;
                Statement st= conexionBDMysql.createStatement();
                st.executeUpdate(mysql);
                System.out.println("Dato de tipo producto esta al macenado");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarTipo.setVisible(false);     
        }
        //------------------------------------------------------    SQL Server  ----------------------------------------------------------------------------------------------
        if(conexion.equals("SQL Server")){          
            conexion1=statusConnectionSQL();
            try{
                String sql="Select tipo from tipoproducto" ;
                Statement st= conexionBDSQL.createStatement();
                st.executeUpdate(sql);
                System.out.println("Dato de tipo producto esta al macenado");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarTipo.setVisible(false);     
        }
    }    
    //----------------------------------------------------------- Metodo de mostrar tipo producto -------------------------------------------------------------------------------
    private void mostrarTP(){
             //Date picker    
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        
        if(conexion.equals("Mysql"))
        {      
            try{   
                String mysql = "select id_tipo,tipo from tipoproducto ";
                Class.forName("com.mysql.jdbc.Driver");
                conexionBDMysql = DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria","root","");             
                txtIdTP.setText("ID");
                txtTP.setText("Tipo de producto");
                Statement st = conexionBDMysql.createStatement();
                ResultSet rs = st.executeQuery(mysql);
                while(rs.next()){
                    dataTP.add(new TipoProducto(rs.getString("id_tipo"),rs.getString("tipo")));
                }
            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println("Error de conexión de My Sql" + e);
            }
            txtIdTP.setCellValueFactory(new PropertyValueFactory<>("id_tipo"));
            txtTP.setCellValueFactory(new PropertyValueFactory<>("tipo"));
            tablaTipoProducto.setItems(dataTP);     
        }
        else{
            System.out.println("No conexion");
        }
        //------------------------------------------------------------------    SQL Server-------------------------------------------------------------------------------------
        if(conexion.equals("SQL Server"))
        {      
            try{   
                String sql = "select id_tipo,tipo from tipoproducto ";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conexionBDSQL = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jardineria","SAINZ","12345");             
                txtIdTP.setText("ID");
                txtTP.setText("Tipo de producto");
                Statement st = conexionBDSQL.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    dataTP.add(new TipoProducto(rs.getString("id_tipo"),rs.getString("tipo")));
                }
            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println("Error de conexión de SQL Server" + e);
            }
            txtIdTP.setCellValueFactory(new PropertyValueFactory<>("id_tipo"));
            txtTP.setCellValueFactory(new PropertyValueFactory<>("tipo"));
            tablaTipoProducto.setItems(dataTP);     
        }
        else{
            System.out.println("No conexion");
        }
        
       // this.ventana_menu.setVisible(true);
       // this.ventana_agregarTipo.setVisible(false);  
    }
    //----------------------------------------------------------- Metodo de Editar tipo producto -------------------------------------------------------------
    @FXML
    void btnEditarTP(ActionEvent event) {
       this.btnEditarTipo.setVisible(true);
       this.txtIdEliminar.setVisible(true);
    }
    @FXML
    private void btnEditarTipo(ActionEvent event){
        int id=Integer.parseInt(txtIdEliminar.getText());
        this.btnEditarProductoContinuar.setVisible(true);
        //obtener(id);
        this.ventana_agregarTipo.setVisible(true);
        this.btnEditarContinuar.setVisible(true);
        this.btnAgregarTipo.setVisible(false);
        this.ventana_menu.setVisible(false);
        System.out.println(""+id);
        //actualizarTipo(id);
    }
    /*private void obtener(int id){
        int idEditar=id;
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        if(conexion.equals("MySQL")){          
            conexion1=statusConnectionMySQL();
            try{
                String mysql="select tipo FROM tipoproducto WHERE id_tipo='"+idEditar+"'" ;
                Statement st= conexionBDMysql.createStatement();
                st.executeUpdate(mysql);
                System.out.println("iaoiaoia"+mysql);
                txtTipo.setText(mysql);
//System.out.println("Dato eliminado");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarTipo.setVisible(false);     
            this.txtTipo.setText(""); 
        }
    }*/
    
    @FXML
    private void btnEditarContinuar(ActionEvent event){
        int id=Integer.parseInt(txtIdEliminar.getText());
        actualizarTipo(id);
        this.btnEditarTipo.setVisible(false);
        this.txtIdEliminar.setVisible(false);
    }
    private void actualizarTipo(int id){
        int idEditar=id;
        //String nombreTipo=txtTipo.getText();
        String nombreTipo =txtTipo.getText().toString();
        //almacenarTipoProducto(nombreTipo.toString());
        System.out.println("Hola , estas pasando por aqui");
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        if(conexion.equals("MySQL")){          
            conexion1=statusConnectionMySQL();
            try{
                String mysql="UPDATE tipoproducto Set tipo='"+nombreTipo+"' where id_tipo='"+idEditar+"'" ;
                Statement st= conexionBDMysql.prepareStatement(mysql);
                st.executeUpdate(mysql);
                System.out.println("Entra: "+mysql);
//System.out.println("Dato eliminado");
            }catch(SQLException e){
                System.out.println("Conexion fallida de editar");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarTipo.setVisible(false);
            this.txtTipo.setText("");
            this.btnAgregarTipo.setVisible(true);
            this.btnEditarProductoContinuar.setVisible(false);
        }
        if(conexion.equals("SQL Server")){          
            conexion1=statusConnectionSQL();
            try{
                String sql="UPDATE tipoproducto Set tipo='"+nombreTipo+"' where id_tipo='"+idEditar+"'" ;
                Statement st= conexionBDSQL.createStatement();
                st.executeUpdate(sql);
                System.out.println("Entra: "+sql);
//System.out.println("Dato eliminado");
            }catch(SQLException e){
                System.out.println("Conexion fallida de editar");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarTipo.setVisible(false);
            this.txtTipo.setText("");
            this.btnAgregarTipo.setVisible(true);
            this.btnEditarProductoContinuar.setVisible(false);
        }
    }
    //---------------------------------------------------- Metodo de Eliminar tipo producto -------------------------------------------------------------------
    @FXML
    private void btnEliminarTPAction(ActionEvent event){
        this.txtIdEliminar.setText("");
        this.btnEliminarCon.setVisible(true);
        this.txtIdEliminar.setVisible(true);
        this.btnEditarTipo.setVisible(false);
    }
    @FXML
    private void btnEliminarConAction(ActionEvent event){
        int id=Integer.parseInt(txtIdEliminar.getText());
        System.out.println("Se elimino un elemento");
        deleteTP(id); //Eliminar
        tablaTipoProducto.getItems().removeAll(tablaTipoProducto.getSelectionModel().getSelectedItems());
        txtIdEliminar.setText("");
        this.txtIdEliminar.setVisible(false);
        this.btnEliminarCon.setVisible(false);
        
    }
  
    public void deleteTP(int id){
        int idEliminar=id;
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        if(conexion.equals("MySQL")){          
            conexion1=statusConnectionMySQL();
            try{
                String mysql="DELETE FROM tipoproducto WHERE id_tipo='"+idEliminar+"'" ;
                Statement st= conexionBDMysql.createStatement();
                st.executeUpdate(mysql);
                System.out.println("Dato eliminado");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarTipo.setVisible(false);     
            this.txtTipo.setText(""); 
        }
        if(conexion.equals("SQL Server")){          
            conexion1=statusConnectionSQL();
            try{
                String sql="DELETE FROM tipoproducto WHERE id_tipo='"+idEliminar+"'" ;
                Statement st= conexionBDSQL.createStatement();
                st.executeUpdate(sql);
                System.out.println("Dato eliminado");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarTipo.setVisible(false);     
            this.txtTipo.setText(""); 
        }
    }
    //-------------------------------------------------------- Metodos de crear Registro de Riego --------------------------------------------------------
    @FXML
    private void btnRR(){
        this.btnEliminarRiegoContinuar.setVisible(false);
        this.txtIdRegistroRiego.setVisible(false);
        this.btnEditarRiegoContinuar.setVisible(false);
    }
    @FXML
    private void btnAgregarRiego(ActionEvent event){
        insertRR(); // Insertar  
        mostrarRR(); //Mostrar
    }
    
    public void insertRR(){
        String dateregistroriego = textDataRiego.getValue().toString();
        String producto = (String) combo2.getSelectionModel().getSelectedItem();
        String conexion=(String) combo.getSelectionModel().getSelectedItem();
        if(conexion.equals("Mysql")){
            String mysql="INSERT INTO registroriego (fechariego,producto) VALUES ('"+dateregistroriego+"','"+producto+"')";
            try{
                Statement st=conexionBDMysql.createStatement();
                st.executeUpdate(mysql);
                System.out.println("Datos agregado de registro de riego ");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);                  
            }    
          this.ventana_menu.setVisible(true);
          this.ventana_registroRiego.setVisible(false);

          this.textDataRiego.setValue(null); 
        }
        //------------------------------------------------------------- SQL Server-----------------------------------------------------------------------------------
        if(conexion.equals("SQL Server")){
            String sql="INSERT INTO registroriego (fechariego,producto) VALUES ('"+dateregistroriego+"','"+producto+"')";
            try{
                Statement st=conexionBDSQL.createStatement();
                st.executeUpdate(sql);
                System.out.println("Datos agregado de registro de riego ");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);                  
            }    
          this.ventana_menu.setVisible(true);
          this.ventana_registroRiego.setVisible(false);

          this.textDataRiego.setValue(null); 
        }
    }
    //---------------------------------------------------------- Metodo de Mostrar Registro de  ---------------------------------------------------------------------
    private void mostrarRR(){
      
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        //  conexion=statusConnectionMySQL();
        if(conexion.equals("Mysql"))
        {      
            try{   
                String mysql = "select id_riego,fechariego,producto from registroriego ";
                Class.forName("com.mysql.jdbc.Driver");
                conexionBDMysql = DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria","root","");             
                txtIdRiego.setText("ID");
                txtFechaRegistro.setText("Fecha de Registro");
                txtProducto.setText("Producto");
                Statement st = conexionBDMysql.createStatement();
                ResultSet rs = st.executeQuery(mysql);
                while(rs.next()){
                    dataRR.add(new RegistroRiego(rs.getString("id_riego"),rs.getString("fechariego"),rs.getString("producto")));

                }
            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println("Error de conexión de My Sql" + e);
            }
            txtIdRiego.setCellValueFactory(new PropertyValueFactory<>("id_riego"));
            txtFechaRegistro.setCellValueFactory(new PropertyValueFactory<>("fechariego"));
            txtProducto.setCellValueFactory(new PropertyValueFactory<>("producto"));
            tablaRegistroRiego.setItems(dataRR);        
        }
        else{
            System.out.println("No conexion");
        }
        //------------------------------------------------------------------- SQL Server -----------------------------------------------------------------------------------------
        if(conexion.equals("SQL Server"))
        {      
            try{   
                String sql = "select id_riego,fechariego,producto from registroriego ";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conexionBDSQL = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jardineria","SAINZ","12345");             
                txtIdRiego.setText("ID");
                txtFechaRegistro.setText("Fecha de Registro");
                txtProducto.setText("Producto");
                Statement st = conexionBDSQL.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    dataRR.add(new RegistroRiego(rs.getString("id_riego"),rs.getString("fechariego"),rs.getString("producto")));

                }
            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println("Error de conexión de My Sql" + e);
            }
            txtIdRiego.setCellValueFactory(new PropertyValueFactory<>("id_riego"));
            txtFechaRegistro.setCellValueFactory(new PropertyValueFactory<>("fechariego"));
            txtProducto.setCellValueFactory(new PropertyValueFactory<>("producto"));
            tablaRegistroRiego.setItems(dataRR);        
        }
        else{
            System.out.println("No conexion");
        }
        this.ventana_menu.setVisible(true);
        this.ventana_registroRiego.setVisible(false);
    }
    //------------------------------------------------------ Metodos para editar registro riego -----------------------------------------------------------------------
    @FXML
    private void btnEditarRiego(ActionEvent event){
        this.btnEditarRiegoContinuar.setVisible(true);
        this.txtIdRegistroRiego.setVisible(true);
    }
    @FXML
    private void btnEditarRiegoContinuar(ActionEvent event){
        this.btnEditarRiegoContinuar.setVisible(false);
        //this.txtIdRegistroRiego.setText("");
        this.txtIdRegistroRiego.setVisible(false);
        this.ventana_menu.setVisible(false);
        this.ventana_registroRiego.setVisible(true);
        this.btnAgregarR.setVisible(false);
        this.btnEditarContinuarRiego.setVisible(true);
    }
    @FXML
    private void btnEditarContinuarRiego(ActionEvent event){
        int id=Integer.parseInt(txtIdRegistroRiego.getText());
        actualizarRiego(id);
        this.ventana_registroRiego.setVisible(false);
        this.ventana_menu.setVisible(true);
    }
    private void actualizarRiego(int id){
         int idEditar=id;
        String producto = (String) combo2.getSelectionModel().getSelectedItem();
        String dateregistroriego = textDataRiego.getValue().toString();
        System.out.println("Hola , estas pasando por aqui");
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        if(conexion.equals("MySQL")){          
            conexion1=statusConnectionMySQL();
            try{
                String mysql="UPDATE registroriego Set fechariego='"+dateregistroriego+"',producto='"+producto+"' where id_riego='"+idEditar+"'" ;
                Statement st= conexionBDMysql.prepareStatement(mysql);
                st.executeUpdate(mysql);
                System.out.println("Entra: "+mysql);
//System.out.println("Dato eliminado");
            }catch(SQLException e){
                System.out.println("Conexion fallida de editar");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_registroRiego.setVisible(false);
            this.btnAgregarR.setVisible(true);
            txtIdRegistroRiego.setText("");
            this.txtIdRegistroRiego.setVisible(false);
            this.btnEditarContinuarRiego.setVisible(false);
            //this.txtId.setText(""); 
        }
        //---------------------------------------------------------------- SQL Server ------------------------------------------------------------------------------------------
        if(conexion.equals("SQL Server")){          
            conexion1=statusConnectionSQL();
            try{
                String sql="UPDATE registroriego Set fechariego='"+dateregistroriego+"',producto='"+producto+"' where id_riego='"+idEditar+"'" ;
                Statement st= conexionBDSQL.createStatement();
                st.executeQuery(sql);
                System.out.println("Entra: "+sql);
//System.out.println("Dato eliminado");
            }catch(SQLException e){
                System.out.println("Conexion fallida de editar");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_registroRiego.setVisible(false);
            this.btnAgregarR.setVisible(true);
            txtIdRegistroRiego.setText("");
            this.txtIdRegistroRiego.setVisible(false);
            this.btnEditarContinuarRiego.setVisible(false);
            //this.txtId.setText(""); 
        }
    }
    //------------------------------------------------------ Metodo de eliminar registro de riego-------------------------------------------------------
    @FXML
    private void btnEliminarRiego(ActionEvent event){
        this.btnEliminarRiegoContinuar.setVisible(true);
        this.txtIdRegistroRiego.setVisible(true);
    }
    @FXML
    private void btnEliminarRiegoContinuar(ActionEvent event){
        int id=Integer.parseInt(txtIdRegistroRiego.getText());
        System.out.println("Se elimino un elemento");
        deleteRR(id); //Eliminar
        tablaRegistroRiego.getItems().removeAll(tablaRegistroRiego.getSelectionModel().getSelectedItems());
        txtIdRegistroRiego.setText("");
        this.txtIdRegistroRiego.setVisible(false);
        this.btnEliminarRiegoContinuar.setVisible(false);
    }
    private void deleteRR(int id){
        int idEliminar=id;
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        if(conexion.equals("MySQL")){          
            conexion1=statusConnectionMySQL();
            try{
                String mysql="DELETE FROM registroriego WHERE id_riego='"+idEliminar+"'" ;
                Statement st= conexionBDMysql.createStatement();
                st.executeUpdate(mysql);
                System.out.println("Dato eliminado");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarTipo.setVisible(false);     
            this.txtIdRegistroRiego.setText("");
            this.txtIdRegistroRiego.setVisible(false);
        }
        //------------------------------------------------------------------- SQL Server----------------------------------------------------------------------------------
        if(conexion.equals("SQL Server")){          
            conexion1=statusConnectionSQL();
            try{
                String sql="DELETE FROM registroriego WHERE id_riego='"+idEliminar+"'" ;
                Statement st= conexionBDSQL.createStatement();
                st.executeUpdate(sql);
                System.out.println("Dato eliminado");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarTipo.setVisible(false);     
            this.txtTipo.setText(""); 
        }
    }
    //------------------------------------------------------ Metodos de crear producto ------------------------------------------------------------------
   /* private void listaTipo(){
        combo1.getItems().addAll("tulipanes","Rosas");
    } */    
    @FXML 
    private void btnAgregarProducto(){
        
        insertP(); // Insertar
        mostrarP(); //Mostrar
    }
    
    private void insertP(){
       String nombreproducto = textNombreP.getText();
       almacenarProducto(nombreproducto);
       String tipoProducto = (String) combo1.getSelectionModel().getSelectedItem();
       String condicionProducto = textCondicionP.getText();  
       String fechaIngreso = textFechaP.getValue().toString();
       String conexion=(String)combo.getSelectionModel().getSelectedItem();
       if(conexion.equals("MySQl")){
        String mysql="INSERT INTO producto (nombreProducto,tipoProducto,condicionActual,fechaIngreso) VALUES ('"+nombreproducto+"','"+tipoProducto+"','"+condicionProducto+"','"+fechaIngreso+"')";
        try{
            Statement st=conexionBDMysql.createStatement();
            st.executeUpdate(mysql);
            System.out.println("Datos agregado ");
        }catch(SQLException e){
            System.out.println("Conexion fallida");
            System.out.println("Error" + e);                  
        }    
        this.ventana_menu.setVisible(true);
        this.ventana_agregarProducto.setVisible(false);

        this.textNombreP.setText(""); 
        this.textTipoProducto.setText("");
        this.textCondicionP.setText(""); 
        this.textFechaP.setValue(null); 
       }
       //------------------------------------------------------------- SQL Server-------------------------------------------------------------------------------
       if(conexion.equals("SQL Server")){
           String sql="INSERT INTO producto (nombreProducto,tipoProducto,condicionActual,fechaIngreso) VALUES ('"+nombreproducto+"','"+tipoProducto+"','"+condicionProducto+"','"+fechaIngreso+"')";
        try{
            Statement st=conexionBDSQL.createStatement();
            st.executeUpdate(sql);
            System.out.println("Datos agregado ");
        }catch(SQLException e){
            System.out.println("Conexion fallida");
            System.out.println("Error" + e);                  
        }    
        this.ventana_menu.setVisible(true);
        this.ventana_agregarProducto.setVisible(false);

        this.textNombreP.setText(""); 
        this.textTipoProducto.setText("");
        this.textCondicionP.setText(""); 
        this.textFechaP.setValue(null); 
       }
    }
    //------------------------------------------------------ Almacenamiento de Combo Box ---------------------------------------------------------------------------------------
    public void almacenarProducto(String nombreproducto){
        String guardar = nombreproducto;
        combo2.getItems().addAll(guardar);
        String almacenar= (String) combo2.getSelectionModel().getSelectedItem();
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        if(conexion.equals("MySQL")){          
            conexion1=statusConnectionMySQL();
            try{
                String mysql="Select nombreproducto from producto Where nombreproducto" ;
                Statement st= conexionBDMysql.createStatement();
                st.executeUpdate(mysql);
                System.out.println("Dato de producto esta almacenado");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarProducto.setVisible(false);     
        }
        //-------------------------------------------------------------- SQL Server----------------------------------------------------------------------------------------------
        if(conexion.equals("SQL Server")){          
            conexion1=statusConnectionSQL();
            try{
                String sql="Select nombreproducto from producto" ;
                Statement st= conexionBDSQL.createStatement();
                st.executeUpdate(sql);
                System.out.println("Dato de producto esta almacenado");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarProducto.setVisible(false);     
        }
    }
    //------------------------------------------------------- Metodo de Mostrar --------------------------------------------------------------------------
    private void mostrarP(){
          //Date picker    
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        //  conexion=statusConnectionMySQL();
        if("MySQL".equals(conexion))
        {      
            try{   
                String mysql = "select id_producto,nombreproducto,tipoproducto,condicionactual,fechaingreso from producto ";
                Class.forName("com.mysql.jdbc.Driver");
                conexionBDMysql = DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria","root","");             
                txtIdTP.setText("ID");
                txtNombre.setText("Nombre de Producto");
                txtTipoProducto.setText("Tipo de Producto");
                txtCondicionActual.setText("Condicion Actual");
                txtFechaIngreso.setText("Fecha de Ingreso");
                Statement st = conexionBDMysql.createStatement();
                ResultSet rs = st.executeQuery(mysql);
                while(rs.next()){
                    dataP.add(new Producto(rs.getString("id_producto"),rs.getString("nombreproducto"),rs.getString("tipoproducto"),rs.getString("condicionactual"),rs.getString("fechaingreso")));

                }
            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println("Error de conexión de My Sql" + e);
            }
            txtIdP.setCellValueFactory(new PropertyValueFactory<>("id_producto"));
            txtNombre.setCellValueFactory(new PropertyValueFactory<>("nombreproducto"));
            txtTipoProducto.setCellValueFactory(new PropertyValueFactory<>("tipoproducto"));
            txtCondicionActual.setCellValueFactory(new PropertyValueFactory<>("condicionactual"));
            txtFechaIngreso.setCellValueFactory(new PropertyValueFactory<>("fechaingreso"));
            tablaProducto.setItems(dataP);        
        }
        //------------------------------------------------------------- SQL Server----------------------------------------------------------------------------------------------
        if(conexion.equals("SQL Server"))
        {      
            try{   
                String sql = "select id_producto,nombreproducto,tipoproducto,condicionactual,fechaingreso from producto ";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conexionBDMysql = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jardineria","SAINZ","12345");             
                txtIdTP.setText("ID");
                txtNombre.setText("Nombre de Producto");
                txtTipoProducto.setText("Tipo de Producto");
                txtCondicionActual.setText("Condicion Actual");
                txtFechaIngreso.setText("Fecha de Ingreso");
                Statement st = conexionBDSQL.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    dataP.add(new Producto(rs.getString("id_producto"),rs.getString("nombreproducto"),rs.getString("tipoproducto"),rs.getString("condicionactual"),rs.getString("fechaingreso")));

                }
            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println("Error de conexión de SQL Server" + e);
            }
            txtIdP.setCellValueFactory(new PropertyValueFactory<>("id_producto"));
            txtNombre.setCellValueFactory(new PropertyValueFactory<>("nombreproducto"));
            txtTipoProducto.setCellValueFactory(new PropertyValueFactory<>("tipoproducto"));
            txtCondicionActual.setCellValueFactory(new PropertyValueFactory<>("condicionactual"));
            txtFechaIngreso.setCellValueFactory(new PropertyValueFactory<>("fechaingreso"));
            tablaProducto.setItems(dataP);        
        }
        else{
            System.out.println("No conexion");
        } 
        this.ventana_menu.setVisible(true);
        this.ventana_agregarProducto.setVisible(false);
    }
    @FXML
    private void btnP(){
        this.txtIdProducto.setVisible(false);
                  this.btnEditarProducto.setVisible(false);
                  this.btnEliminarProducto.setVisible(false);
    }
    //-----------------------------------------------Metodos para editar producto----------------------------------------------------
    @FXML
    private void btnEditarP(ActionEvent event){
        this.btnEliminarProducto.setVisible(false);
        this.btnEditarProducto.setVisible(true);
        this.txtIdProducto.setVisible(true);
    }
    @FXML
    private void btnEditarProducto(ActionEvent event){
        this.ventana_agregarProducto.setVisible(true);
        this.ventana_menu.setVisible(false);
        this.btnEditarProducto.setVisible(false);
        this.btnEliminarProducto.setVisible(false);
        this.txtIdProducto.setVisible(false);
        this.btnEditarProductoContinuar.setVisible(true);
        this.btnAgregarP.setVisible(false);
    }
    @FXML
    private void btnEditarProductoContinuar(ActionEvent event){
        int id=Integer.parseInt(txtIdProducto.getText());
        actualizarProducto(id);
        this.ventana_agregarProducto.setVisible(false);
        this.ventana_menu.setVisible(true);
    }
    private void actualizarProducto(int id){
        int idEditar=id;
        //String nombreTipo=txtTipo.getText();
        String nombreproducto = textNombreP.getText();
       String tipoProducto = (String) combo1.getSelectionModel().getSelectedItem();
       String condicionProducto = textCondicionP.getText();  
       String fechaIngreso = textFechaP.getValue().toString();
        //almacenarTipoProducto(nombreTipo.toString());
        System.out.println("Hola , estas pasando por aqui");
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        if(conexion.equals("MySQL")){          
            conexion1=statusConnectionMySQL();
            try{
                String mysql="UPDATE producto Set nombreProducto='"+nombreproducto+"',tipoProducto='"+tipoProducto+"',condicionActual='"+condicionProducto+"',fechaIngreso='"+fechaIngreso+"' where id_producto='"+ idEditar+"'";
                Statement st= conexionBDMysql.prepareStatement(mysql);
                st.executeUpdate(mysql);
                System.out.println("Entra: "+mysql);
//System.out.println("Dato eliminado");
            }catch(SQLException e){
                System.out.println("Conexion fallida de editar");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarProducto.setVisible(false);
            this.txtIdProducto.setText("");
            this.txtIdProducto.setVisible(false);
            this.btnEditarProductoContinuar.setVisible(false);
            this.btnAgregarP.setVisible(true);
        }
        //---------------------------------------------------------------- SQL Server ----------------------------------------------------------------------------
        if(conexion.equals("SQL Server")){          
            conexion1=statusConnectionSQL();
            try{
                String sql="UPDATE producto Set nombreProducto='"+nombreproducto+"',tipoProducto='"+tipoProducto+"',condicionActual='"+condicionProducto+"',fechaIngreso='"+fechaIngreso+"' where id_producto='"+ idEditar+"'";
                Statement st= conexionBDSQL.createStatement();
                st.executeUpdate(sql);
                System.out.println("Entra: "+sql);
//System.out.println("Dato eliminado");
            }catch(SQLException e){
                System.out.println("Conexion fallida de editar");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarProducto.setVisible(false);
            this.txtIdProducto.setText("");
            this.txtIdProducto.setVisible(false);
            this.btnEditarProductoContinuar.setVisible(false);
            this.btnAgregarP.setVisible(true);
        }
    }
    //-------------------------------------------------Metodos para eliminar-----------------------------------------------------------------
    @FXML
    private void btnEliminarP(ActionEvent event){
        this.btnEditarProducto.setVisible(false);
        this.btnEliminarProducto.setVisible(true);
        this.txtIdProducto.setVisible(true);
    }
    @FXML
    private void btnEliminarProdu(ActionEvent event){
        int id=Integer.parseInt(txtIdProducto.getText());
        System.out.println("Se elimino un elemento");
        System.out.println(""+id);
        deleteP(id); //Eliminar
        tablaProducto.getItems().removeAll(tablaProducto.getSelectionModel().getSelectedItems());
        txtIdProducto.setText("");
        this.txtIdProducto.setVisible(false);
        this.btnEliminarProducto.setVisible(false);
        
    }
    private void deleteP(int id){
        int idEliminar=id;
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        if(conexion.equals("MySQL")){          
            conexion1=statusConnectionMySQL();
            try{
                String mysql="DELETE FROM producto WHERE id_producto='"+idEliminar+"'" ;
                Statement st= conexionBDMysql.createStatement();
                st.executeUpdate(mysql);
                System.out.println("Dato eliminado");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarTipo.setVisible(false);     
            this.txtTipo.setText(""); 
        }
        //------------------------------------------------------------------- SQL Server -----------------------------------------------------------------------------------------
        if(conexion.equals("SQL Server")){          
            conexion1=statusConnectionSQL();
            try{
                String sql="DELETE FROM producto WHERE id_producto='"+idEliminar+"'" ;
                Statement st= conexionBDSQL.createStatement();
                st.executeUpdate(sql);
                System.out.println("Dato eliminado");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_agregarTipo.setVisible(false);     
            this.txtTipo.setText(""); 
        }
    }
    
    //----------------------------------------------------------Historial Fotografia----------------------------------------------------------------------
    @FXML
    private void btnHF(){
        this.txtIdHistorialFoto.setVisible(false);
        this.btnEditarHistorial.setVisible(false);
        this.btnEliminarHistorial.setVisible(false);
    }
    @FXML
    private void btnSeleccionarImagen(ActionEvent event) throws IOException{
        FileChooser filechooser=new FileChooser();
        FileChooser.ExtensionFilter extFilterJPG=new FileChooser.ExtensionFilter("JPG files(*.jpg)","*.JPG");
        FileChooser.ExtensionFilter extFilterPNG=new FileChooser.ExtensionFilter("PNG files(*.png)","*.PNG");
        filechooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
        
        File file=filechooser.showOpenDialog(null);
        try{
            BufferedImage bufferedimage=ImageIO.read(file);
            Image image=SwingFXUtils.toFXImage(bufferedimage,null);
            imagen.setImage(image);
            urlHistorial.setText(file.toURL().toString());
        }catch(Exception e){
            System.out.println(""+e);
        }
    }
    @FXML
    private void btnAgregarHistorial(ActionEvent event){
        insertHF();  //Insertar
        mostrarHF(); //Mostrar
    }
    
    private void insertHF(){
        String fechaHistorial = textDateHistorial.getValue().toString();
        String fotografia = urlHistorial.getText().toString();
        String conexion=(String) combo.getSelectionModel().getSelectedItem();
        //System.out.println(""+fotografia);
        if(conexion.equals("MySQL")){
            String mysql="INSERT INTO historial (fechahistorial,fotografia) VALUES ('"+fechaHistorial+"','"+fotografia+"')";
            try{
                Statement st=conexionBDMysql.createStatement();
                st.executeUpdate(mysql);
                System.out.println("Datos agregado ");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);                  
            }    

          this.textFechaP.setValue(null); 
          this.urlHistorial.setText("");  
          this.ventana_registroHistorial.setVisible(false);
          this.ventana_menu.setVisible(true);
        }
        //------------------------------------------------------------- SQL Server --------------------------------------------------------------------------------------------
        if(conexion.equals("SQL Server")){
            String sql="INSERT INTO historial (fechahistorial,fotografia) VALUES ('"+fechaHistorial+"','"+fotografia+"')";
            try{
                Statement st=conexionBDSQL.createStatement();
                st.executeUpdate(sql);
                System.out.println("Datos agregado ");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);                  
            }    

          this.textFechaP.setValue(null); 
          this.urlHistorial.setText("");  
          this.ventana_registroHistorial.setVisible(false);
          this.ventana_menu.setVisible(true);
        }
    }
    
    //--------------------------------------------- Metodo de Mostrar -------------------------------------------
    public void mostrarHF(){
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        //  conexion=statusConnectionMySQL();
        if("MySQL".equals(conexion))
        {      
            try{   
                String mysql = "select id_historial,fechahistorial,fotografia from historial ";
                Class.forName("com.mysql.jdbc.Driver");
                conexionBDMysql = DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria","root","");             
                txtIdHistorial.setText("ID");
                txtFechaHistorial.setText("Fecha de Historial");
                txtUrlHistorial.setText("Fotografia");
                Statement st = conexionBDMysql.createStatement();
                ResultSet rs = st.executeQuery(mysql);
                while(rs.next()){
                    dataHF.add(new HistorialFotografia(rs.getString("id_historial"),rs.getString("fechahistorial"),rs.getString("fotografia")));

                }
            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println("Error de conexión de My Sql" + e);
            }
            txtIdHistorial.setCellValueFactory(new PropertyValueFactory<>("id_historial"));
            txtFechaHistorial.setCellValueFactory(new PropertyValueFactory<>("fechahistorial"));
            txtUrlHistorial.setCellValueFactory(new PropertyValueFactory<>("fotografia"));
            tablaHistorial.setItems(dataHF);        
        }
        //---------------------------------------------------------- SQL Server ---------------------------------------------------------------------------------------------------
        if(conexion.equals("SQL Server"))
        {      
            try{   
                String sql = "select id_historial,fechahistorial,fotografia from historial ";
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conexionBDSQL = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=jardineria","SAINZ","12345");             
                txtIdHistorial.setText("ID");
                txtFechaHistorial.setText("Fecha de Historial");
                txtUrlHistorial.setText("Fotografia");
                Statement st = conexionBDSQL.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    dataHF.add(new HistorialFotografia(rs.getString("id_historial"),rs.getString("fechahistorial"),rs.getString("fotografia")));

                }
            }
            catch(ClassNotFoundException | SQLException e){
                System.out.println("Error de conexión de My Sql" + e);
            }
            txtIdHistorial.setCellValueFactory(new PropertyValueFactory<>("id_historial"));
            txtFechaHistorial.setCellValueFactory(new PropertyValueFactory<>("fechahistorial"));
            txtUrlHistorial.setCellValueFactory(new PropertyValueFactory<>("fotografia"));
            tablaHistorial.setItems(dataHF);        
        }
        else{
            System.out.println("No conexion");
        }
        
       // this.ventana_menu.setVisible(true);
       // this.ventana_registroHistorial.setVisible(false);
    
    }
    //----------------------------------------------------------------Metodos para editar Historial----------------------------------------------------------
    @FXML
    private void btnEditarH(ActionEvent event){
        this.txtIdHistorialFoto.setVisible(true);
        this.btnEditarHistorial.setVisible(true);
        this.btnEliminarHistorial.setVisible(false);
    }
    @FXML
    private void btnEditarHistorial(ActionEvent event){
        this.ventana_menu.setVisible(false);
        this.btnAgregarHistorial.setVisible(false);
        this.ventana_registroHistorial.setVisible(true);
        this.txtIdHistorialFoto.setVisible(false);
        this.btnEditarHistorial.setVisible(false);
        this.btnEditarHistorialContinuar.setVisible(true);
    }
    @FXML
    private void btnEditarHistorialContinuar(ActionEvent event){
        int id=Integer.parseInt(txtIdHistorialFoto.getText());
        actualizarHistorial(id);
        //System.out.println(""+id);
        this.ventana_registroHistorial.setVisible(false);
        this.ventana_menu.setVisible(true);
    }
    private void actualizarHistorial(int id){
        int idEditar=id;
        //String nombreTipo=txtTipo.getText();
        String fechaHistorial = textDateHistorial.getValue().toString();
        String fotografia = urlHistorial.getText().toString();
        //almacenarTipoProducto(nombreTipo.toString());
        System.out.println("Hola , estas pasando por aqui");
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        if(conexion.equals("MySQL")){          
            conexion1=statusConnectionMySQL();
            try{
                String mysql="UPDATE historial Set fechahistorial='"+fechaHistorial+"',fotografia='"+fotografia+"' where id_historial='"+idEditar+"'";
                Statement st= conexionBDMysql.prepareStatement(mysql);
                st.executeUpdate(mysql);
                System.out.println("Entra: "+mysql);
//System.out.println("Dato eliminado");
            }catch(SQLException e){
                System.out.println("Conexion fallida de editar");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_registroHistorial.setVisible(false);
            this.txtIdHistorialFoto.setText("");
            this.txtIdHistorialFoto.setVisible(false);
            this.btnAgregarHistorial.setVisible(false);
            this.btnEditarHistorial.setVisible(false);
        }
        //-------------------------------------------------------------------- SQL Server -------------------------------------------------------------------------------------
        if(conexion.equals("SQL Server")){          
            conexion1=statusConnectionSQL();
            try{
                String sql="UPDATE historial Set fechahistorial='"+fechaHistorial+"',fotografia='"+fotografia+"' where id_historial='"+idEditar+"'";
                Statement st= conexionBDSQL.createStatement();
                st.executeUpdate(sql);
                System.out.println("Entra: "+sql);
//System.out.println("Dato eliminado");
            }catch(SQLException e){
                System.out.println("Conexion fallida de editar");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_registroHistorial.setVisible(false);
            this.txtIdHistorialFoto.setText("");
            this.txtIdHistorialFoto.setVisible(false);
            this.btnAgregarHistorial.setVisible(false);
            this.btnEditarHistorial.setVisible(false);
        }
    }
    //------------------------------------------------------Metodos para Eliminar Historial Fotografia------------------------------------------------------
    @FXML
    private void btnEliminarH(ActionEvent event){
        this.btnEliminarHistorial.setVisible(true);
        this.txtIdHistorialFoto.setVisible(true);
        this.btnEditarHistorial.setVisible(false);
    }
    @FXML
    private void btnEliminarHistorial(ActionEvent event){
        int id=Integer.parseInt(txtIdHistorialFoto.getText());
        System.out.println("Se elimino un elemento");
        System.out.println(""+id);
        deleteH(id); //Eliminar
        tablaHistorial.getItems().removeAll(tablaHistorial.getSelectionModel().getSelectedItems());
        txtIdHistorialFoto.setText("");
        this.txtIdHistorialFoto.setVisible(false);
        this.btnEliminarHistorial.setVisible(false);
    }
    private void deleteH(int id){
        int idEliminar=id;
        String conexion= (String) combo.getSelectionModel().getSelectedItem();
        if(conexion.equals("MySQL")){          
            conexion1=statusConnectionMySQL();
            try{
                String mysql="DELETE FROM historial WHERE id_historial='"+idEliminar+"'" ;
                Statement st= conexionBDMysql.createStatement();
                st.executeUpdate(mysql);
                System.out.println("Dato eliminado");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_registroHistorial.setVisible(false);     
            this.txtIdHistorialFoto.setText(""); 
        }
        //------------------------------------------------------------------ SQL Server -------------------------------------------------------------------------------------------
        if(conexion.equals("SQL Server")){          
            conexion1=statusConnectionSQL();
            try{
                String sql="DELETE FROM historial WHERE id_historial='"+idEliminar+"'" ;
                Statement st= conexionBDMysql.createStatement();
                st.executeUpdate(sql);
                System.out.println("Dato eliminado");
            }catch(SQLException e){
                System.out.println("Conexion fallida");
                System.out.println("Error" + e);              }    
            this.ventana_menu.setVisible(true);
            this.ventana_registroHistorial.setVisible(false);     
            this.txtIdHistorialFoto.setText(""); 
        }
    }
    @FXML
    private void btnlistRR(){
        
    }
    
    @FXML
    private void btnAgregarHistorial(){
        this.ventana_menu.setVisible(true);
        this.ventana_registroHistorial.setVisible(false);
    }
    
    @FXML
    private void btnCerrar(){ 
        this.ventana_inicio.setVisible(true);
        this.ventana_menu.setVisible(false);
    }

    private Statement setString(int i, String conexion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
