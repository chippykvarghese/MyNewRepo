package utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public void selectAValueUsingSelectByVisibleText(WebElement element,String text)
	{	
		Select select=new Select(element);
		select.selectByVisibleText(text);		
	}
	
	public void selectAValueUsingSelectByIndex(WebElement element, int index) 
	{
		Select select=new Select(element);
		select.selectByIndex(index);
    }
	
	public void selectAValueUsingSelectByValue(WebElement element, String value) 
	{
		Select select=new Select(element);
		select.selectByValue(value);
    }
	
	public void checkTheCheckbox(WebElement checkbox) 
	{
	     if (!checkbox.isSelected()) {
	            checkbox.click();
	        }
	}

	public void uncheckTheCheckedbox(WebElement checkbox) 
	{
	        if (checkbox.isSelected()) {
	            checkbox.click();
	        }
	}

    public void selectRadioButton(WebElement radioButton) {
	        if (!radioButton.isSelected()) {
	            radioButton.click();
	       }
	}

}