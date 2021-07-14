package com.infogain.et.event.util;

import java.util.Map;
import java.util.Set;

import com.infogain.et.event.dto.CSVDataDTO;

public class PNROperation {
    /**
     * <ul>
     * <li>Iterate over input records and increment the data keeper to track the total number of created records.
     * <li>With versionLimit, random version number will generated in the given limit.
     * <li>According to the fetched randomVersion, version of the locator will be created.
     * <li>If version is either 1 or 2, it will be added in parentDataKeeper else it will be stored in dataKeeper.
     * <li>Parent locator also set in dataKeeper. Parent Locator will be set only if
     * 		<li>- Version number is equivalent to randomVersion
     * 		<li>- Locator's last digit is even and
     *      <li>- It should not be first locator, as it is referring to it's previous locator
     * </ul>
     * @param inputRecords
     * @param versionLimit
     * @param locatorVersionMap
     * @param parentDataKeeper
     * @param dataKeeper
     */
    public static void setLocatorAndVersion(Integer inputRecords, Integer versionLimit,
                                            Map<String, Integer> locatorVersionMap, Set<CSVDataDTO> parentDataKeeper, Set<CSVDataDTO> dataKeeper) {

        // Get random prefix alphabet in between A to Z
        String prefix = DataGeneratorUtility.getPNRPrefix();

        for (Integer increment = Constant.ONE, dataKeeperSize = Constant.ONE;
             increment <= inputRecords && dataKeeperSize <= inputRecords; increment++) {
            String padded = String.format("%05d",
                    increment);  // Generate String of 5 char with increment value and pad remaining with zero
            String locator = prefix + padded;  // locator is combination of prefix and padded value

            locatorVersionMap.put(locator, Constant.ONE);
            Integer randomVersion = DataGeneratorUtility
                    .getRandomVersion(versionLimit); // Get random version which depends on limit

            /** Iterate over version for each locator */
            for (Integer version = Constant.ONE;
                 version <= randomVersion && dataKeeperSize <= inputRecords; version++) {
                CSVDataDTO data = new CSVDataDTO();
                String parentLocator = "";
                data.setLocator(locator);
                data.setVersion(version.toString());
                data.setParent_locator(parentLocator);
                data.setData(Constant.DTO_DATA);

                if (version == Constant.ONE || version == Constant.TWO) {
                    parentDataKeeper.add(data);
                    dataKeeperSize++;
                } else {
                    if (version == randomVersion && increment > Constant.ONE && increment % Constant.TWO == 0) {
                        padded = String.format("%05d", increment - Constant.ONE);
                        parentLocator = prefix + padded;
                        data.setParent_locator(parentLocator);
                    }
                    dataKeeper.add(data);
                    dataKeeperSize++;
                }
            }
        }
    }

}
