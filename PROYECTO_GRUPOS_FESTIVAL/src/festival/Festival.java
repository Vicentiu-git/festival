package festival;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextArea;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Festival extends JFrame {

	//declaramaos las variables privadas
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private Connection conn;
	private ResultSet rs;
	private ResultSet rs2;
	private JTextField textField_4;
	private JTextArea textArea;
	private JTextArea textArea_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Festival frame = new Festival();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Festival() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 470);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(237, 241, 241));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido! Organiza tu festival favorito!!");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(237, 10, 328, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Grupo");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_1.setBounds(80, 63, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CIF");
		lblNewLabel_2.setBounds(24, 98, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(133, 95, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setBounds(24, 135, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(133, 132, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Género");
		lblNewLabel_4.setBounds(24, 175, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(133, 172, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Nr. integrantes");
		lblNewLabel_5.setBounds(24, 218, 85, 13);
		contentPane.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(206, 215, 23, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Cod. Festival");
		lblNewLabel_6.setBounds(24, 261, 85, 13);
		contentPane.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setBounds(133, 258, 96, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Festival");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_7.setBounds(370, 45, 63, 23);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Insertar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//asociamos el método insertar a la acción de pulsar el boton insertar
				insertar();
				
			}
		});
		btnNewButton.setBounds(24, 364, 96, 21);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_3 = new JButton("Borrar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//asociamos el método borra a su correspondiente botón
				borra();
			}
		});
		btnNewButton_3.setBounds(144, 364, 96, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Modificar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//asociamos el actualizar borra al botón modificar
				actualizar();
			}
		});
		btnNewButton_4.setBounds(260, 364, 96, 21);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Atras");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//asociamos el método previous al botón atras
					previous();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_5.setBounds(24, 320, 96, 21);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Siguiente");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//asociamos el método next al boton siguiente
				next();
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_6.setBounds(144, 320, 96, 21);
		contentPane.add(btnNewButton_6);
		
		next();
		
		//relacionamos la variable textarea al nuevo objeto creado e invocamos el metodo llenarcaja
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		textArea.setBounds(327, 125, 344, 202);
		contentPane.add(textArea);
		llenarcaja(textArea);
		
		
		
		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setForeground(new Color(87, 15, 2));
		textArea_1.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
		textArea_1.setBounds(327, 78, 401, 25);
		contentPane.add(textArea_1);
		llenarcajaFesti(textArea_1);
		
		
	
	}
	
	//creamos el método llenarcajas para asociar cada textField a la consulta correspondiente
	// que realizamos con rs escogiendo cada una por su nombre de columna
	void llenarcajas()
    {
        try {
           textField.setText(rs.getString("cif"));
           textField_1.setText(rs.getString("nombre"));
           textField_2.setText(rs.getString("genero"));
           textField_3.setText(rs.getString("integrantes"));
           textField_4.setText(rs.getString("id_festival"));
       } catch (SQLException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       
    }
	
	//creamos llenarcaja para llenar el textArea principal con los grupos del Festival en tiempo real
	void llenarcaja(JTextArea textArea)
    {
		
        try {
        	textArea.setText((rs.getString("nombre")));
        	//usamos un bucle para recorrer los elementos y pintarlos
        	while(rs.next()) {	
					textArea.append("\r\n"+(rs.getString("nombre")));				
        	}
        	rs.beforeFirst();
          
        
       } catch (SQLException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       
    }
	//método que creamos para llenar el Area superior con el nombre del Festival haciendo 
	//la consulta correspondiente con otra query diferente dentro de rs2 que selecciona la 
	//tabla Festival
	void llenarcajaFesti(JTextArea textArea_1)
    {	
        try {
				textArea_1.append((rs2.getString("nombre"))+" - "+(rs2.getString("localizacion"))+" - "+(rs2.getString("fecha")));        	
					       
       } catch (SQLException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       
    }
	//realizamos el método conectar con los parámetros necesarios y creando las querys que vamos a usar
	void conectar() throws SQLException {
		conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		
	    conn = DriverManager.getConnection(
			"jdbc:mysql://127.0.0.1:333/festivales","vicen","root");

		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery(
	 		"SELECT * FROM grupo ");
			
		Statement stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs2 = stmt2.executeQuery(
	 		"SELECT * FROM festival ");
		
		System.out.println("Conexión establecida");
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//creamos el método next, que primero nos conecta a la base de datos y despues comprueba
	// si las querys tienen datos para llenarlas. En caso afirmativo invoca llenarcajas()
	void next () throws SQLException {
		if (rs==null)
        {
         conectar(); 
        }
		boolean condi1= rs.next() && !rs.isAfterLast();
		boolean condi2= rs2.next() && !rs2.isLast();
		
       if(condi1 || condi2)
	   {     
	     llenarcajas();       
	   }
       
	}
	//el método previous nos conecta a la base de datos y comprueba si hay datos moviendo el
	//cursor hacia atras, en caso afirmativo los llena con dichos datos
	void previous () throws SQLException {
		if (rs==null)
        {
            conectar();
          
       }
       try {
           if(rs.previous())//After Last was giving invalid cursor state error
               {
                   llenarcajas();
               }
       } catch (SQLException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
	}
	//el método insertar nos permite introducir datos en la tabla Grupo con el texto
	//que recoge de los textFields, para luego hacer el insert mediante la PreparedStatement creada
	void insertar() {
        try {
            
       PreparedStatement ps;
      ps = conn.prepareStatement("INSERT INTO grupo VALUES (?,?,?,?,?)");

      String vid=textField.getText();
      String vnombre=textField_1.getText();
      String vgen=textField_2.getText();
      String vnr=textField_3.getText();
      String vcodF=textField_4.getText();
      
    
       ps.setString(1, vid);
       ps.setString(2, vnombre);
       ps.setString(3, vgen);
       ps.setString(4, vnr);
       ps.setString(5, vcodF);
       
       //usamos executeUpdate para realizar acciones dinámicas como insertar, modificar o borrar
       int regdev= ps.executeUpdate();
       //para poder actualizar el TextArea con los datos en tiempo real cerramos conexiones y volvemos a abrir
       ps.close();
       conn.close();
       conectar();
       JOptionPane.showMessageDialog(contentPane, "Registro Insertado", "Insertar", JOptionPane.INFORMATION_MESSAGE);
       next();
       llenarcaja(textArea);

       }   
        catch (SQLException ex) {
            System.err.println(ex.getMessage());           
        }
   }
	//creamos actualizar de manera muy similar a insertar con la peculiaridad de obtener los 
	//resultados del update mediante la clave primaria para despues ordenar los resultados como en el ps
	void actualizar() {
        try {
            
           
       PreparedStatement ps;
      
      ps = conn.prepareStatement("UPDATE grupo SET nombre=?, genero=?, integrantes=?, id_festival=? WHERE cif=?");


      String vid=textField.getText();
      String vnombre=textField_1.getText();
      String vgen=textField_2.getText();
      String vnr=textField_3.getText();
      String vcodF=textField_4.getText();
   
    
      ps.setString(1, vnombre);
      ps.setString(2, vgen);
      ps.setString(3, vnr);
      ps.setString(4, vcodF);
      ps.setString(5, vid);
      int regdev= ps.executeUpdate();
       ps.close();
       conn.close();
       conectar();
       //conectar(textArea);
       JOptionPane.showMessageDialog(contentPane, "Registro Modificado", "Actualizar", JOptionPane.INFORMATION_MESSAGE);
       next();
       llenarcaja(textArea);
      
       }   
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
            
        }

   }
	//con dicho método borramos el registro entero que se selecciona mediante la clave primaria
void borra() {
        
        try {
                       
            PreparedStatement ps;
 
          ps = conn.prepareStatement("DELETE FROM grupo WHERE cif=?");

           String vid=textField.getText();
                   
            ps.setString(1, vid);
           
           int regdev= ps.executeUpdate();
            ps.close();
            conn.close();
            conectar();
            JOptionPane.showMessageDialog(contentPane, "Registro Borrado", "Borrar", JOptionPane.INFORMATION_MESSAGE);
     
           next();
           llenarcaja(textArea);
                     
            }   
             catch (SQLException ex) {
                 System.err.println(ex.getMessage());
                 
             }       
    }
}
