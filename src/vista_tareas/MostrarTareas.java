package vista_tareas;


import java.awt.event.WindowEvent;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import controlador.ControladorAplicacionImp;
import controlador.EventoNegocio;
import selector_vista.EventoVista;
import tarea.Tarea;
import vista.Vista;
import departamento.Departamento;


/**
 *
 * @author Daniel
 */
public class MostrarTareas extends javax.swing.JFrame implements Vista {

	static private MostrarTareas mostrarTareas;
	

    private MostrarTareas() {
        initComponents();
    }
    
    /**
     * Permite obtener la vista
     * @return la vista
     */
    static public MostrarTareas obtenerInstancia(){
    	if(mostrarTareas == null){
    		mostrarTareas = new MostrarTareas();
    	}
    	
    	return mostrarTareas;
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
    	
    	this.setTitle("Mostrar Tareas");

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        
        jTextArea1.setEditable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );

        addWindowListener(new java.awt.event.WindowAdapter() { //cuando se cirre la pesta�a borra lo anterior
            public void windowClosing(java.awt.event.WindowEvent evt) {
        
     		jTextArea1.setText(""); //borra lo anterior
            }
        });
        
        
		ImageIcon image = new ImageIcon("res/icono.png");

		this.setIconImage(image.getImage());
        
        pack();
    }// </editor-fold>

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarTareas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration

    /**
     * Muestra las listas de entidades que se desean
     */
    public void mostrar(){
    	ControladorAplicacionImp.obtenerInstancia().accion(EventoNegocio.MOSTRAR_TAREAS, null);
    }
    
	@Override
	public void actualizar(int id_evento_vista, Object datos) {
		if(id_evento_vista == EventoVista.MOSTRAR_TAREAS_EXITO){
			Collection<Tarea> lista_tareas = (Collection)datos;
	
			jTextArea1.append("  ID\tNOMBRE\n\n");
			
			for(Tarea t: lista_tareas){
				jTextArea1.append("  " + t.getId() +"\t" + t.getNombre() + "\n"); 
			}
			
		}
		else if(id_evento_vista == EventoVista.MOSTRAR_TAREAS_FALLO){
			JOptionPane.showMessageDialog(null, "ERROR!! No se han encontrado la tarea para mostrar", "Mostrar Tareas", JOptionPane.ERROR_MESSAGE);
		}
		
	}	

	public void windowClosing(WindowEvent e){
		
		
	}
}
