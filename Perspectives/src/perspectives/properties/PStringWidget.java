package perspectives.properties;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import perspectives.base.Property;
import perspectives.base.PropertyWidget;
import perspectives.base.PropertyType;

public class PStringWidget extends PropertyWidget {
	
	public PStringWidget(Property p) {
		super(p);
		// TODO Auto-generated constructor stub
	}


	JTextField control = null;
	JLabel readOnlyControl = null;
	
	public void widgetLayout()
	{			
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		this.add(new JLabel(this.p.getDisplayName()));

		final PropertyWidget th = this;
		
		control = new JTextField();
		control.setText(((PString)this.p.getValue()).stringValue());
		control.setMaximumSize(new Dimension(100,20));
		control.setPreferredSize(new Dimension(100,20));
		
		readOnlyControl = new JLabel();
		readOnlyControl.setText(((PString)this.p.getValue()).stringValue());
		//readOnlyControl.setMaximumSize(new Dimension(200,20));
		
		control.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent e) {

		        th.updateProperty(new PString(control.getText()));      
		     }
		});
		
		//this.add(Box.createRigidArea(new Dimension(5,1)));
		this.add(Box.createHorizontalGlue());
		this.add(control);	
		
	
		
		p.setReadOnly(p.getReadOnly());
		p.setVisible(p.getVisible());
	}		


	@Override
	public <T extends PropertyType> void propertyValueUpdated(T newvalue) {
		control.setText(((PString)newvalue).stringValue());	
		readOnlyControl.setText(((PString)newvalue).stringValue());	
	}

	@Override
	public void propertyReadonlyUpdated(boolean r) {
		if (control != null)
		{
			if (r)
			{
				this.remove(control);					
				this.add(readOnlyControl,2);
			}
			else
			{
				this.remove(readOnlyControl);					
				this.add(control,2);
			}
		}		
	}

}