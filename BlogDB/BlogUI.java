package BlogDB;
import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class BlogUI extends JPanel {

	   private static final long serialVersionUID = 1L;
	   private JTextField userNameEntry = new JTextField(30);
	   private JTextField date = new JTextField(30);
	   private JTextField blogEntry = new JTextField(30);
	   private JTextField moderator = new JTextField(30);
	   private JTextField comments = new JTextField(30);
	   
	   

	   private JButton createButton = new JButton("Create");
	   private JButton retrieveButton = new JButton("Retrieve");
	   private JButton updateButton = new JButton("Update");
	   private JButton deleteButton = new JButton("Delete");
	   private JButton moderateButton = new JButton("Moderate");
	   private JButton commentButton = new JButton("Add Comment");
	  
	 
	   Connection conn;
	   private BlogController controller = new BlogController();

	   public BlogUI() {
	      setBorder(new TitledBorder
	      (new EtchedBorder(),"Blog Entries"));
	      setLayout(new BorderLayout(5, 5));
	      add(initFields(), BorderLayout.NORTH);
	      add(initButtons(), BorderLayout.CENTER);
	  //    setFieldData(controller.moveFirst());
	   }

	   private JPanel initButtons() {
	      JPanel panel = new JPanel();
	      panel.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
	      panel.add(createButton);
	      createButton.addActionListener(new ButtonHandler());
	      panel.add(retrieveButton);
	      retrieveButton.addActionListener(new ButtonHandler());
	      panel.add(updateButton);
	      updateButton.addActionListener(new ButtonHandler());
	      panel.add(deleteButton);
	      deleteButton.addActionListener(new ButtonHandler());
	      panel.add(moderateButton);
	      moderateButton.addActionListener(new ButtonHandler());
	      panel.add(commentButton);
	      commentButton.addActionListener(new ButtonHandler());
	      return panel;
	   }

	   private JPanel initFields() {
	      JPanel panel = new JPanel();
	      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	      panel.add(new JLabel("Username"));
	      panel.add(userNameEntry);
	      userNameEntry.setEnabled(true);
	      panel.add(new JLabel("Date"));
	      panel.add(date);
	      date.setEnabled(true);
	      panel.add(new JLabel("Blog Entry"));
	      panel.add(blogEntry);
	      blogEntry.setEnabled(true);
	      panel.add(new JLabel("Moderator"));
	      panel.add(moderator);
	      moderator.setEnabled(true);
	      panel.add(new JLabel("Add Comment"));
	      panel.add(comments);
	      comments.setEnabled(true);
	      return panel;
	   }

	   private Blog getFieldData() {

	     String newUserName = userNameEntry.getText();
	     String newDate = date.getText();
	     String newBlogEntry = blogEntry.getText();
	     String newModerator = moderator.getText();
	     String newComments = comments.getText();
	        
	     Blog blog = new Blog(newUserName, newDate, newBlogEntry, newModerator, newComments);
	     return blog;
	    	     
	   }

	   private void setFieldData(Blog blog) {
	      userNameEntry.setText(blog.getUserName());
	      date.setText(blog.getDate());
	      blogEntry.setText(blog.getBlogEntry());
	      moderator.setText(blog.getModerator());
	      comments.setText(blog.getComments());
	    
	   }

	   private boolean isEmptyFieldData() {
	      return (date.getText().trim().isEmpty()
	         && blogEntry.getText().trim().isEmpty()
	         && moderator.getText().trim().isEmpty()
	         && comments.getText().trim().isEmpty());
	      
	   }

	   private class ButtonHandler implements ActionListener {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	         Blog blog = getFieldData();
	         switch (e.getActionCommand()) {
	         case "Save":
	            if (isEmptyFieldData()) {
	               JOptionPane.showMessageDialog(null,
	               "Cannot create an empty record");
	               return;
	            }
	            if (controller.createBlog(blog) != null)
	               JOptionPane.showMessageDialog(null,
	               "New blog created successfully.");
	               createButton.setText("Add");
	               break;
	         case "Create":
	            blog.setUserName("");
	            blog.setDate("");
	            blog.setBlogEntry("");
	            blog.setModerator("");
	            blog.setComments("");
	            setFieldData(blog);
	            createButton.setText("Save");
	            break;
	         case "Retrieve":
	        	 if (isEmptyFieldData()) {
		               JOptionPane.showMessageDialog(null,
		               "Cannot retrieve an empty record");
		               return;
		            }
	        	 controller.getBlog(blog.getUserName());
		         JOptionPane.showMessageDialog(
		         null,"Member with Username:"
		               + String.valueOf(blog.getUserName()
		               + " is retrieved successfully"));
	        	 break;
	         case "Update":
	            if (isEmptyFieldData()) {
	               JOptionPane.showMessageDialog(null,
	               "Cannot update an empty record");
	               return;
	            }
	            if (controller.updateBlog(blog) != null)
	               JOptionPane.showMessageDialog(
	               null,"Member with Username:" + String.valueOf(blog.getUserName()
	               + " is updated successfully"));
	               break;
	         case "Delete":
	            if (isEmptyFieldData()) {
	               JOptionPane.showMessageDialog(null,
	               "Cannot delete an empty record");
	               return;
	            }
	            controller.deleteBlog(blog);
	            JOptionPane.showMessageDialog(
	               null,"Member with Username:"
	               + String.valueOf(blog.getUserName()
	               + " is deleted successfully"));
	               break;
	         case "Moderate":
	        	 break;
	         case "Add Comment":
	        	 break;
	         default:
	            JOptionPane.showMessageDialog(null,
	            "invalid command");
	         }
	      }
	   }
	}