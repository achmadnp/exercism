import java.util.HashSet;
import java.util.List;
import java.util.Set;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        Set<String> cardSet = new HashSet<>();
        for (String card : cards) {
            cardSet.add(card);
        }
        return cardSet;
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        Set<String> myCurrent = new HashSet<>(myCollection);
        Set<String> theirCurrent = new HashSet<>(theirCollection);

        if (myCollection.isEmpty() || theirCollection.isEmpty()) {
            return false;
        }

        for (String myCard : myCollection) {
            if (theirCollection.contains(myCard)) {
                myCurrent.remove(myCard);
                theirCurrent.remove(myCard);
            }
        }


        return !myCurrent.isEmpty() && !theirCurrent.isEmpty();
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        boolean cardExists = true;
        Set<String> firstSet = collections.getFirst();
        Set<String> commonCards = new HashSet<>();

        for (String card : firstSet) {
            cardExists = true;
            for (int i = 1; i < collections.size(); i++) {
                if (!collections.get(i).contains(card)) {
                    cardExists = false;
                }
            }
            if (cardExists) {
                commonCards.add(card);
            }
            
        }

        return commonCards;
            
    }
    

    static Set<String> allCards(List<Set<String>> collections) {
        Set<String> allCardSet = new HashSet<>();

        for (Set<String> cardSet : collections) {
            allCardSet.addAll(cardSet);
        }

        return allCardSet;
    }
}
