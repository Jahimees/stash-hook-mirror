package com.englishtown.bitbucket.hook;

import com.atlassian.bitbucket.setting.Settings;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Default implementation of {@link SettingsReflectionHelper}
 */
@Component
public class DefaultSettingsReflectionHelper implements SettingsReflectionHelper {

    /**
     * Set the values field of the {@link Settings} via reflection
     *
     * @param values   the values to set
     * @param settings the settings to set the values field on
     */
    @Override
    public void set(Map<String, Object> values, Settings settings) {

        try {
            Field field = settings.getClass().getDeclaredField("values");
            field.setAccessible(true);
            field.set(settings, values);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException("Unable to encrypt the password.  Check for an updated version of the mirror " +
                    "hook.", e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unable to encrypt the password.  Check for an updated version of the mirror " +
                    "hook.", e);
        }

    }
}
