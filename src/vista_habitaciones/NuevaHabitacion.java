package vista_habitaciones;

import habitacion.TransferHabitacion;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import selector_vista.EventoVista;
import vista.Vista;
import controlador.ControladorAplicacionImp;
import controlador.EventoNegocio;

/**
*
* @author Daniel
*/
public class NuevaHabitacion extends javax.swing.JFrame implements Vista{
   
   
	static private NuevaHabitacion nuevoHabitacion;

	  /** Creates new form NuevoDepartamento */
	  private NuevaHabitacion() {
	      initComponents();
	  }
	  
	  /**
	   * Obtiene la instancia de la ventana
	   * @return la instancia de la ventana
	   */
	  static public NuevaHabitacion obtenerInstancia(){
	   
	  if(nuevoHabitacion == null){
		   nuevoHabitacion = new NuevaHabitacion();
	   }
	   
	   return nuevoHabitacion;
	  }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
   private void initComponents() {

       jLabel1 = new javax.swing.JLabel();
       jLabel2 = new javax.swing.JLabel();
       campo_habitacion = new javax.swing.JFormattedTextField();
       campo_capacidad = new javax.swing.JFormattedTextField();
       jButton1 = new javax.swing.JButton();

       setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
       setTitle("Nueva Habitaci�n");
       setResizable(false);

       jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
       jLabel1.setText("N�mero Habitaci�n");

       jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
       jLabel2.setText("Capacidad");

       campo_habitacion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

       campo_capacidad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

       jButton1.setText("Aceptar");

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addContainerGap()
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addGroup(layout.createSequentialGroup()
                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addComponent(jLabel1)
                           .addComponent(jLabel2))
                       .addGap(18, 18, 18)
                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addComponent(campo_capacidad, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                           .addComponent(campo_habitacion)))
                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                       .addGap(0, 0, Short.MAX_VALUE)
                       .addComponent(jButton1)))
               .addContainerGap())
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addContainerGap()
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(jLabel1)
                   .addComponent(campo_habitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGap(18, 18, 18)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addComponent(jLabel2)
                   .addComponent(campo_capacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
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
        	  campo_capacidad.setText("");
        	  campo_habitacion.setText("");
           }
       });
       
       
		ImageIcon image = new ImageIcon("res/icono.png");

		this.setIconImage(image.getImage());
       
       pack();
   }// </editor-fold>                        

   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
	   
	   TransferHabitacion transferHabitacion = new TransferHabitacion();
	   transferHabitacion.setCapacidad(Integer.valueOf(this.campo_capacidad.getText()).intValue());
	   transferHabitacion.setNumero_hab(Integer.valueOf(this.campo_habitacion.getText()).intValue());
	   
       ControladorAplicacionImp.obtenerInstancia().accion(EventoNegocio.NUEVA_HABITACI�N, transferHabitacion);
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
           java.util.logging.Logger.getLogger(NuevaHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           java.util.logging.Logger.getLogger(NuevaHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           java.util.logging.Logger.getLogger(NuevaHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (javax.swing.UnsupportedLookAndFeelException ex) {
           java.util.logging.Logger.getLogger(NuevaHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
       //</editor-fold>

       /* Create and display the form */
       java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
               new NuevaHabitacion().setVisible(true);
           }
       });
   }

   // Variables declaration - do not modify                     
   private javax.swing.JFormattedTextField campo_capacidad;
   private javax.swing.JFormattedTextField campo_habitacion;
   private javax.swing.JButton jButton1;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   // End of variables declaration                   

	@Override
	public void actualizar(int id_evento_vista, Object datos) {
		//Borra lo anterior
		campo_capacidad.setText("");
		campo_habitacion.setText("");
		
		if(id_evento_vista == EventoVista.NUEVA_HABITACION_EXITO){
			JOptionPane.showMessageDialog(null, "Se ha creado la habitaci�n con �xito con n�mero de habitaci�n " + (int)datos, "Nueva Habitaci�n", JOptionPane.INFORMATION_MESSAGE);		
		}	
		else if(id_evento_vista == EventoVista.NUEVA_HABITACION_CAPACIDAD_NO_VALIDA){
			JOptionPane.showMessageDialog(null, "ERROR!! La capacidad de la habitaci�n debe ser mayor que 1", "Nueva Habitaci�n", JOptionPane.ERROR_MESSAGE);
		}
		else if (id_evento_vista == EventoVista.NUEVA_HABITACION_NUMERO_YA_EXISTE){
			JOptionPane.showMessageDialog(null, "ERROR!! El N�mero de la habitaci�n introducido ya existe", "Nueva Habitaci�n", JOptionPane.ERROR_MESSAGE);
		}
		else if (id_evento_vista == EventoVista.NUEVA_HABITACION_FALLO){
			JOptionPane.showMessageDialog(null, "ERROR!! Ha ocurrido un error con la BD", "Nueva Habitaci�n", JOptionPane.ERROR_MESSAGE);
		}
	}
}
