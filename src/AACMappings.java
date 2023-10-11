import structures.AssociativeArray;
import java.io.*;

/**
 * Represents the mappings for all pages in the AAC
 * 
 * @author Chloe Kelly
 * @author Catie Baker (documentation)
 */

public class AACMappings {

  //FIELDS ****
  AACCategory cat;
  AssociativeArray<String, AACCategory> nameMap;

  //CONSTRUCTORS ****
  /**
   * Mappings for the AAC
   */
  public AACMappings(String filename){
    this.cat = new AACCategory("");
    this.nameMap = new AssociativeArray<String, AACCategory>();
    nameMap.set("", this.cat);
  } //AACMappings(name)
  
  //METHODS ****

  /**
   * Adds the mapping to the current category (or the default category if that is the current category)
   */
  public void add(String imageLoc, String text){
    this.cat.addItem(imageLoc, text);
    if(this.isCategory(imageLoc)){
      nameMap.set(imageLoc, new AACCategory(text));
    }
  } //add(String, String)

  /**
   * Provides an array of all the images in the current category
   */
  public String[] getImageLocs() {
    return this.cat.getImages();
  } // getImageLocs()

  /**
   * Given the image location selected, it determines the associated text with the image. 
   * If the image provided is a category, it also updates the AAC's current category to be the 
   * category associated with that image
   * 
   */
  public String getText(String imageLoc) {
    String text = this.cat.getText(imageLoc); 
    if(this.isCategory(imageLoc)){
      setCategory(imageLoc);
    }
    return text;
  } //getText(String)

  /**
   * Gets the current category
   */
  public String getCurrentCategory() {
    return this.cat.getCategory(); 
  } //getCurrentCategory()

  /**
   * Determines if the image represents a category or text to speak
   */
  public boolean isCategory(String imageLoc){
    return (imageLoc.equals("img/food/plate.png") || imageLoc.equals("img/clothing/hanger.png"));
  } //isCategory(String)

  /**
   * Resets the current category of the AAC back to the default category
   */
  public void reset(){
    setCategory("");
  } //reset()

  /**
   * Writes the ACC mappings stored to a file. 
   */
  public void writeToFile(String filename){
    try {
      FileWriter fileWrite = new FileWriter(filename);
      PrintWriter pen = new PrintWriter(fileWrite);
      for(int i = 1; i < nameMap.size(); i++){  //iterate through the categories
        //Print the category image and name
        pen.println(nameMap.getKey(i) +" "+ (nameMap.get("")).getText(nameMap.getKey(i))); 
        //Get the images (keys) of the category
        String[] imgs = nameMap.get(nameMap.getKey(i)).getImages();
        //Print the images in the category
        for(int j = 0; j < imgs.length; j++){
          pen.println(">"+imgs[j]+" "+nameMap.get(nameMap.getKey(i)).getText(imgs[j]));
        }//for
      }//for
      pen.close();
    } catch (Exception e) {
      System.err.println("File does not exist");
      System.exit(1);
    }
  } //writeToFile(String)

  //PRIVATE METHOD
  /**
   * Sets the category to the one represented by key.
   */
  void setCategory(String key){
    try { this.cat = nameMap.get(key); } catch (Exception e) { }
  }//setCategory(String)
}
