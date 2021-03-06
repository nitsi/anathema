package net.sf.anathema.framework.environment;

import net.sf.anathema.framework.configuration.IInitializationPreferences;

import javax.swing.ToolTipManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.util.Locale;

public class AnathemaEnvironment {

  public static void initTooltipManager(IInitializationPreferences initializationPreferences) {
    ToolTipManager.sharedInstance().setInitialDelay(0);
    ToolTipManager.sharedInstance().setReshowDelay(0);
    int toolTipTime = initializationPreferences.getTooltipTimePreference();
    ToolTipManager.sharedInstance().setDismissDelay(toolTipTime * 1000);
  }

  public static void initLookAndFeel(IInitializationPreferences initializationPreferences)
          throws ClassNotFoundException,
          InstantiationException,
          IllegalAccessException,
          UnsupportedLookAndFeelException {
    new LookAndFeelInitializer(initializationPreferences).initialize();
  }

  public static void initLocale(IInitializationPreferences preferences) {
    Locale.setDefault(preferences.getPreferredLocale());
  }
}