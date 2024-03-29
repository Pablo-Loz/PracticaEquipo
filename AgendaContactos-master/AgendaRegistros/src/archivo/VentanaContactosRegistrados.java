
package archivo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;



/**
 *
 * 
 */
public class VentanaContactosRegistrados extends javax.swing.JFrame {

     DefaultTableModel modelo = new DefaultTableModel();
    
    /**
     * Creates new form VentanaContactosRegistrados
     */
    public VentanaContactosRegistrados() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Registros guardados");
        cargarModelo();
    }

    private void cargarModelo(){
        try{
           
            modelo.addColumn("Nombre");
            modelo.addColumn("Correo");
            modelo.addColumn("Telefono");
            tablaRegistros.setModel(modelo);
            cargarArchivo();
            
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    private void cargarArchivo() throws IOException{
        String fila[];
        
        try{
           
            FileReader archivo = new FileReader("AgendaContactos.txt");
            BufferedReader lectura = new BufferedReader(archivo);
            
            String linea = lectura.readLine();
           
            
            while(linea != null){
                 fila = linea.split("%");
                 modelo.addRow(fila);
                 linea = lectura.readLine();
            }
            
       }catch(FileNotFoundException e){
           System.out.println(e);
       }
    }
    
    
   
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRegistros = new javax.swing.JTable();
        botonAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(189, 192, 205));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel1.setText("Registros guardados");

        tablaRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaRegistros);

        botonAtras.setText("Atras");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });
        
        JButton añadir = new JButton();
        añadir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		VentanaRegistros Vent = new VentanaRegistros();
        		Vent.setVisible(true);
        		setVisible(false);
        		
        		
        	}
        });
        añadir.setText("Añadir");
        
        JButton eliminarboton = new JButton("Eliminar");
        
        eliminarboton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		 VentanaElimar eli = new VentanaElimar();
        		 eli.setVisible(true);
         		setVisible(false);
        		
        		
        	}
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(30, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
        					.addGroup(jPanel1Layout.createSequentialGroup()
        						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 865, GroupLayout.PREFERRED_SIZE)
        						.addGap(22))
        					.addGroup(jPanel1Layout.createSequentialGroup()
        						.addComponent(botonAtras, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
        						.addGap(160)
        						.addComponent(eliminarboton, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
        						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(añadir, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
        						.addGap(110)))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(jLabel1)
        					.addGap(254))))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel1)
        			.addGap(40)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(botonAtras, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
        					.addComponent(eliminarboton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
        				.addComponent(añadir, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {
        VentanaRegistros registros = new VentanaRegistros();
        this.setVisible(false);
        registros.setVisible(true);
    }

  
    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaContactosRegistrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaContactosRegistrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaContactosRegistrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaContactosRegistrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaContactosRegistrados().setVisible(true);
            }
        });
    }

    // Variables declaration 
    private javax.swing.JButton botonAtras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaRegistros;
}
