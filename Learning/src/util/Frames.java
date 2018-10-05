package util;

import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import crm.TestNgBasics;

public class Frames {
	
	/*
	 * Select a frame by its (zero-based) index. That is, if a page has multiple frames (more than 1), the first frame would be at index "0", the second at index "1" and so on.
	 */
	public static void switchToFrameId(int frame) {
		try {
			TestNgBasics.driver.switchTo().frame(frame);
			System.out.println("Navigated to frame with id " + frame);
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to locate frame with id " + frame
					+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to navigate to frame with id " + frame
					+ e.getStackTrace());
		}
	}
	/*
	 * Select a frame by its name or ID. Frames located by matching name attributes are always given precedence over those matched by ID.
	Parameters: name Or Id - the name of the frame or the id of the frame element.
	Returns: driver focused on the given frame (current frame)
	Throws: NoSuchFrameException - If the frame is not found
	 */
	public static void switchToFrameName(String frame) {
		try {
			TestNgBasics.driver.switchTo().frame(frame);
			System.out.println("Navigated to frame with name " + frame);
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to locate frame with id " + frame
					+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to navigate to frame with id " + frame
					+ e.getStackTrace());
		}
	}
	/* Select a frame using its previously located WebElement.
	 * Parameters: frameElement - The frame element to switch to.
	Returns: driver focused on the given frame (current frame).
	Throws: NoSuchFrameException - If the given element is neither an iframe nor a frame element. And StaleElementReferenceException - If the WebElement has gone stale.
	 */
	public static void switchToFrameElement(WebElement frameElement) {
		try {
			
			if (isElementPresent(frameElement)) {
				TestNgBasics.driver.switchTo().frame(frameElement);
				System.out.println("Navigated to frame with element "+ frameElement);
			} else {
				System.out.println("Unable to navigate to frame with element "+ frameElement);
			}
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to locate frame with element " + frameElement + e.getStackTrace());
		} catch (StaleElementReferenceException e) {
			System.out.println("Element with " + frameElement + "is not attached to the page document" + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to navigate to frame with element " + frameElement + e.getStackTrace());
		}
	}
	private static boolean isElementPresent(WebElement frameElement) {
		// TODO Auto-generated method stub
		return false;
	}
	public void switchToParentAndChildFrame(String ParentFrame, String ChildFrame) {
		try {
			TestNgBasics.driver.switchTo().frame(ParentFrame).switchTo().frame(ChildFrame);
			System.out.println("Navigated to innerframe with id " + ChildFrame
					+ "which is present on frame with id" + ParentFrame);
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to locate frame with id " + ParentFrame
					+ " or " + ChildFrame + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to navigate to innerframe with id "
					+ ChildFrame + "which is present on frame with id"
					+ ParentFrame + e.getStackTrace());
		}
	}
//After working with the frames, main important is to come back to the web page. if we don't switch back to the default page, driver will throw an exception. Below is the code snippet to switch back to the default content.

public static void switchtoDefaultFrame() {
		try {
			TestNgBasics.driver.switchTo().defaultContent();
			System.out.println("Navigated back to webpage from frame");
		} catch (Exception e) {
			System.out.println("unable to navigate back to main webpage from frame"
							+ e.getStackTrace());
		}
	}
}
