import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DialingCodes {
    Map dialingMap;

    public DialingCodes() {
        this.dialingMap = new HashMap<Integer, String>();
    }

    public Map<Integer, String> getCodes() {
        return this.dialingMap;
    }

    public void setDialingCode(Integer code, String country) {
        this.dialingMap.put(code, country);
    }

    public String getCountry(Integer code) {
        return this.dialingMap.get(code).toString();
    }

    public void addNewDialingCode(Integer code, String country) {
        // check the key
        if (this.dialingMap.containsKey(code)) {
            return;
        }

        // check values exist
        Collection<String> countriesValue = this.dialingMap.values();

        if (countriesValue.contains(country)) {
            return;
        }
        this.dialingMap.put(code, country);
    }

    public Integer findDialingCode(String country) {
        if (this.dialingMap.containsValue(country)) {
            Set<Integer> keyset = dialingMap.keySet();
            for (int key : keyset) {
                if (this.dialingMap.get(key) == country) {
                    return key;
                }
            }
        }
        return null;
    }

    public void updateCountryDialingCode(Integer code, String country) {
        if (!this.dialingMap.containsValue(country)) {
            return;
        }
        Integer keyToUpdate = findDialingCode(country);
        this.dialingMap.remove(keyToUpdate);
        this.dialingMap.put(code, country);
    }
}
