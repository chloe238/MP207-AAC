import structures.AssociativeArray;

/**
 * Represents the mappings for a single page of items that should be displayed
 * 
 * @author Chloe Kelly
 * @author Catie Baker (documentation)
 */

public class AACCategory {
  //FIELDS ****
  /**
   * The name of the category
   */
  String name;

  /**
   * The underlying associative array
   */
  AssociativeArray<String, String> imageMap;

  //CONSTRUCTOR ****
  /**
   * Creates a new empty category with the given name
   * 
   */
  public AACCategory(String name){
    this.name = name;
    this.imageMap = new AssociativeArray<String, String>();
  } //AACCategory(String)

  //METHODS ****

  /**
   * Adds the mapping of the imageLoc to the text to the category.
   */
  public void addItem(String imageLoc, String text){
    this.imageMap.set(imageLoc, text);
  } //addItem(String, String)

  /**
   * Returns the name of the category
   */
  public String getCategory(){
    return name;
  } //getCategory()

  /**
   * Returns an array of all the images in the category
   */
  public String[] getImages(){
    String[] strings = new String[this.imageMap.size()];
    for(int i = 0; i < this.imageMap.size(); i++){
      strings[i] = this.imageMap.getKey(i);
    }
    return strings;
  } //getImages()

  /**
   * Returns the text associated with the given image loc in this category
   */
  public String getText(String imageLoc){
    try{
      return this.imageMap.get(imageLoc);
    } catch (Exception e){
      return "Error: Could not find text";
    }
  } //getText(String)

  /**
   * Determines if the provided images is stored in the category
   */
  public boolean hasImage(String imageLoc){
    return imageMap.hasKey(imageLoc);
  } //hasImage(String)
}

