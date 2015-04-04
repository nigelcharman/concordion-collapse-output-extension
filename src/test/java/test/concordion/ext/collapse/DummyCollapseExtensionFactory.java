package test.concordion.ext.collapse;

import org.concordion.api.extension.ConcordionExtension;
import org.concordion.api.extension.ConcordionExtensionFactory;
import org.concordion.ext.collapse.CollapseOutputExtension;

public class DummyCollapseExtensionFactory implements ConcordionExtensionFactory {
    
	private static CollapseOutputExtension collapseOutputExtension = null;

	private static String styleClass = null;
	
	private static String jsDir = null;
	
	private static String cssDir = null;

	private static String linkText = null;
    
    public static void setStyleClass(String styleClass) {
    	DummyCollapseExtensionFactory.styleClass = styleClass;
    }
    
    @Override
    public ConcordionExtension createExtension() {    	
    	collapseOutputExtension = new CollapseOutputExtension();
    	
    	if(DummyCollapseExtensionFactory.styleClass != null) {
    		collapseOutputExtension.withClassName(DummyCollapseExtensionFactory.styleClass);
    	}

    	if(DummyCollapseExtensionFactory.jsDir != null) {
    		collapseOutputExtension.withJavascriptOutputDirectory(DummyCollapseExtensionFactory.jsDir);
    	}
    	
    	if(DummyCollapseExtensionFactory.cssDir != null) {
    		collapseOutputExtension.withCSSOutputDirectory(DummyCollapseExtensionFactory.cssDir);
    	}
    	
    	if(DummyCollapseExtensionFactory.linkText != null) {
    		collapseOutputExtension.withLinkText(linkText);
    	}
    	
    	return collapseOutputExtension;
    }

	public static void setJavascriptOutputDirectory(String jsDir) {
		DummyCollapseExtensionFactory.jsDir = jsDir;
		
	}

	public static void setCSSOutputDirectory(String cssDir) {
		DummyCollapseExtensionFactory.cssDir = cssDir;
		
	}

	public static void setLinkText(String linkText) {
		DummyCollapseExtensionFactory.linkText  = linkText;
		
	}
}