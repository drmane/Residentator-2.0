package vista_residentes;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import residente.TransferResidente;
import residente.TransferResidenteEstudiante;
import residente.TransferResidenteNoEstudiante;
import selector_vista.EventoVista;
import vista.Vista;
import controlador.ControladorAplicacionImp;
import controlador.EventoNegocio;

/**
*
* @author Daniel
*/
public class NuevoResidente extends javax.swing.JFrame implements Vista {

   
  static private NuevoResidente nuevoResidente;

  /** Creates new form NuevoDepartamento */
  private NuevoResidente() {
      initComponents();
  }
  
  /**
   * Obtiene la instancia de la ventana
   * @return la instancia de la ventana
   */
  static public NuevoResidente obtenerInstancia(){
	   if(nuevoResidente == null){
		   nuevoResidente = new NuevoResidente();
	   }
	   
	   return nuevoResidente;
  }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
   private void initComponents() {

       buttonGroupSexo = new javax.swing.ButtonGroup();
       jLabel1 = new javax.swing.JLabel();
       jLabel2 = new javax.swing.JLabel();
       jLabel3 = new javax.swing.JLabel();
       jLabel4 = new javax.swing.JLabel();
       jLabel5 = new javax.swing.JLabel();
       jFormattedTextField1 = new javax.swing.JFormattedTextField();
       jFormattedTextField2 = new javax.swing.JFormattedTextField();
       jFormattedTextField3 = new javax.swing.JFormattedTextField();
       jFormattedTextField5 = new javax.swing.JFormattedTextField();
       jRadioButton1 = new javax.swing.JRadioButton();
       jRadioButton2 = new javax.swing.JRadioButton();
       jLabel6 = new javax.swing.JLabel();
       jRadioButton3 = new javax.swing.JRadioButton();
       jLabel7 = new javax.swing.JLabel();
       jFormattedTextField4 = new javax.swing.JFormattedTextField();
       jLabel8 = new javax.swing.JLabel();
       jLabel9 = new javax.swing.JLabel();
       jFormattedTextField6 = new javax.swing.JFormattedTextField();
       jFormattedTextField7 = new javax.swing.JFormattedTextField();
       jButton1 = new javax.swing.JButton();

       setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
       setTitle("Nuevo Residente");
       setResizable(false);

       jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
       jLabel1.setText("DNI");

       jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
       jLabel2.setText("Nombre");

       jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
       jLabel3.setText("Apellidos");

       jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
       jLabel4.setText("Sexo");

       jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
       jLabel5.setText("N�mero de Habitaci�n");

       buttonGroupSexo.add(jRadioButton1);
       jRadioButton1.setSelected(true);
       jRadioButton1.setText("M (masculino)");

       buttonGroupSexo.add(jRadioButton2);
       jRadioButton2.setText("F (femenino)");

       jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
       jLabel6.setText("Estudiante");

       jRadioButton3.setSelected(true);
       jRadioButton3.setText("Si");
       jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               jRadioButton3ActionPerformed(evt);
           }
       });

       jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
       jLabel7.setText("Email");

       jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
       jLabel8.setText("Tel�fono");

       jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
       jLabel9.setText("Domicilio");

       jFormattedTextField6.setEnabled(false);

       jFormattedTextField7.setEnabled(false);

       jButton1.setText("Aceptar");

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
               .addContainerGap()
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addComponent(jLabel4)
                   .addComponent(jLabel3)
                   .addComponent(jLabel2)
                   .addComponent(jLabel1))
               .addGap(48, 48, 48)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                   .addComponent(jRadioButton2)
                   .addComponent(jFormattedTextField2)
                   .addComponent(jFormattedTextField1)
                   .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(jRadioButton1))
               .addGap(29, 29, 29)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                   .addGroup(layout.createSequentialGroup()
                       .addGap(169, 169, 169)
                       .addComponent(jButton1))
                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                       .addGroup(layout.createSequentialGroup()
                           .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                               .addComponent(jLabel8)
                               .addComponent(jLabel9))
                           .addGap(83, 83, 83)
                           .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                               .addComponent(jFormattedTextField6)
                               .addComponent(jFormattedTextField7)))
                       .addGroup(layout.createSequentialGroup()
                           .addComponent(jLabel5)
                           .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                           .addComponent(jFormattedTextField5))
                       .addGroup(layout.createSequentialGroup()
                           .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                               .addComponent(jLabel6)
                               .addComponent(jLabel7))
                           .addGap(74, 74, 74)
                           .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                               .addGroup(layout.createSequentialGroup()
                                   .addComponent(jRadioButton3)
                                   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                               .addComponent(jFormattedTextField4)))))
               .addGap(20, 20, 20))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addContainerGap()
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(jLabel1)
                   .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(jFormattedTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(jLabel5))
               .addGap(18, 18, 18)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(jLabel2)
                   .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(jLabel6)
                   .addComponent(jRadioButton3))
               .addGap(18, 18, 18)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(jLabel3)
                   .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(jLabel7)
                   .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGap(18, 18, 18)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(jLabel4)
                   .addComponent(jRadioButton1)
                   .addComponent(jLabel8)
                   .addComponent(jFormattedTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGap(18, 18, 18)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(jLabel9)
                   .addComponent(jFormattedTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(jRadioButton2))
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
               .addComponent(jButton1)
               .addContainerGap())
       );
       
       jButton1.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               jButton1ActionPerformed(evt);
           }
       });
       
       //Borra el los datos correspondiente al cerrar la ventana
       this.addWindowListener(new java.awt.event.WindowAdapter() {
           @Override
           public void windowClosing(java.awt.event.WindowEvent windowEvent) {
       		//Borra lo anterior
       		jFormattedTextField1.setText("");
       		jFormattedTextField2.setText("");
       		jFormattedTextField3.setText("");
       		jFormattedTextField4.setText("");
       		jFormattedTextField5.setText("");
       		jFormattedTextField6.setText("");
       		jFormattedTextField7.setText("");
           }
       });

		ImageIcon image = new ImageIcon("res/icono.png");

		this.setIconImage(image.getImage());
       
       pack();
   }// </editor-fold>                        

   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
	   
	   TransferResidente transferResidente;
	   
	   if(jRadioButton3.isSelected()){
		   transferResidente = new TransferResidenteEstudiante();
		   
		  ((TransferResidenteEstudiante) transferResidente).setEmail(jFormattedTextField4.getText());
	   }
	   else{
		   transferResidente = new TransferResidenteNoEstudiante();
		   
		   ((TransferResidenteNoEstudiante) transferResidente).setTelefono(Integer.valueOf(jFormattedTextField6.getText()));
		   ((TransferResidenteNoEstudiante) transferResidente).setDomicilio(jFormattedTextField7.getText());
	   }
	   
	   transferResidente.setDni(jFormattedTextField1.getText());
	   transferResidente.setNombre(jFormattedTextField2.getText());
	   transferResidente.setApellidos(jFormattedTextField3.getText());
	   
	   if(jRadioButton1.isSelected()){
		   transferResidente.setSexo('M');
	   }
	   
	   if(jRadioButton2.isSelected()){
		   transferResidente.setSexo('F');
	   }
	   
	   transferResidente.setNum_hab(Integer.valueOf(jFormattedTextField5.getText()));
	   
       ControladorAplicacionImp.obtenerInstancia().accion(EventoNegocio.NUEVO_RESIDENTE, transferResidente);
   }
   
   private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {    
	   
	   jFormattedTextField4.setText("");
	   jFormattedTextField6.setText("");
	   jFormattedTextField7.setText("");
	   
       if(jRadioButton3.isSelected()){
           //email
           jFormattedTextField4.setEnabled(true);
           
           //tel�fono y domicilio
           jFormattedTextField6.setEnabled(false);
           jFormattedTextField7.setEnabled(false);
       }
       else{
           //email
           jFormattedTextField4.setEnabled(false);
           
           //tel�fono y domicilio
           jFormattedTextField6.setEnabled(true);
           jFormattedTextField7.setEnabled(true);
       }
   }                                             

   /**
    * @param args the command line arguments
    */
   public static void main(String args[]) {
       /* Set the Nimbus look and feel */
       //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
       /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
        */
       try {
           for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
               if ("Nimbus".equals(info.getName())) {
                   javax.swing.UIManager.setLookAndFeel(info.getClassName());
                   break;
               }
           }
       } catch (ClassNotFoundException ex) {
           java.util.logging.Logger.getLogger(NuevoResidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           java.util.logging.Logger.getLogger(NuevoResidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           java.util.logging.Logger.getLogger(NuevoResidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (javax.swing.UnsupportedLookAndFeelException ex) {
           java.util.logging.Logger.getLogger(NuevoResidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
       //</editor-fold>

       /* Create and display the form */
       java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
               new NuevoResidente().setVisible(true);
           }
       });
   }

   // Variables declaration - do not modify                     
   private javax.swing.ButtonGroup buttonGroupSexo;
   private javax.swing.JButton jButton1;
   private javax.swing.JFormattedTextField jFormattedTextField1;
   private javax.swing.JFormattedTextField jFormattedTextField2;
   private javax.swing.JFormattedTextField jFormattedTextField3;
   private javax.swing.JFormattedTextField jFormattedTextField4;
   private javax.swing.JFormattedTextField jFormattedTextField5;
   private javax.swing.JFormattedTextField jFormattedTextField6;
   private javax.swing.JFormattedTextField jFormattedTextField7;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JLabel jLabel6;
   private javax.swing.JLabel jLabel7;
   private javax.swing.JLabel jLabel8;
   private javax.swing.JLabel jLabel9;
   private javax.swing.JRadioButton jRadioButton1;
   private javax.swing.JRadioButton jRadioButton2;
   private javax.swing.JRadioButton jRadioButton3;
   // End of variables declaration                   

	@Override
	public void actualizar(int id_evento_vista, Object datos) {
		//Borra lo anterior
		jFormattedTextField1.setText("");
		jFormattedTextField2.setText("");
		jFormattedTextField3.setText("");
		jFormattedTextField4.setText("");
		jFormattedTextField5.setText("");
		jFormattedTextField6.setText("");
		jFormattedTextField7.setText("");
		
		if(id_evento_vista == EventoVista.NUEVO_RESIDENTE_EXITO){
			JOptionPane.showMessageDialog(null, "Se ha creado el residente con �xito", "Nuevo Residente", JOptionPane.INFORMATION_MESSAGE);		
		}	
		else if(id_evento_vista == EventoVista.NUEVO_RESIDENTE_DNI_YA_EXISTE){
			JOptionPane.showMessageDialog(null, "ERROR!! El DNI introducido ya existe", "Nuevo Residente", JOptionPane.ERROR_MESSAGE);
		}
		else if (id_evento_vista == EventoVista.NUEVO_RESIDENTE_HABITACION_NO_EXISTE){
			JOptionPane.showMessageDialog(null, "ERROR!! La habitaci�n introducida no existe", "Nuevo Residente", JOptionPane.ERROR_MESSAGE);
		}
		else if (id_evento_vista == EventoVista.NUEVO_RESIDENTE_HABITACION_LLENA){
			JOptionPane.showMessageDialog(null, "ERROR!! La habitaci�n introducida est� llena", "Nuevo Residente", JOptionPane.ERROR_MESSAGE);
		}
		else if (id_evento_vista == EventoVista.NUEVO_RESIDENTE_FALLO){
			JOptionPane.showMessageDialog(null, "ERROR!! Ha ocurrido un error con la BD", "Nuevo Residente", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
