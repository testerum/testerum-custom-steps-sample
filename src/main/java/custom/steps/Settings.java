package custom.steps;

import com.testerum_api.testerum_steps_api.annotations.settings.DeclareSetting;
import com.testerum_api.testerum_steps_api.services.TesterumServiceLocator;
import com.testerum_api.testerum_steps_api.test_context.logger.TesterumLogger;
import com.testerum_api.testerum_steps_api.test_context.settings.RunnerSettingsManager;
import com.testerum_api.testerum_steps_api.test_context.settings.model.Setting;
import com.testerum_api.testerum_steps_api.test_context.settings.model.SettingType;

@DeclareSetting(
    key = Settings.MY_SETTING_KEY,
    label = "My Setting",
    type = SettingType.TEXT,
    defaultValue = "Success is not the key to happiness. Happiness is the key to success. If you love what you are doing, you will be successful.",
    description = "This is the description of my Setting",
    category = Settings.MY_SETTING_CATEGORY
)
public class Settings {
    public static final String MY_SETTING_KEY = "MY_SETTING_KEY";
    public static final String MY_SETTING_CATEGORY = "My Settings";

    private final TesterumLogger logger = TesterumServiceLocator.getTesterumLogger();
    private final RunnerSettingsManager settingsManager = TesterumServiceLocator.getSettingsManager();

    public void logMySetting() {
        Setting setting = settingsManager.getSetting(MY_SETTING_KEY);
        logger.info("MY SETTING = " + setting.getResolvedValue());
    }
}
