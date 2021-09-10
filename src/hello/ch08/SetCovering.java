package hello.ch08;

import java.util.*;

public class SetCovering {

    public static void main(String[] args) {
        Set statesNeeded = new HashSet(Arrays.asList("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));
        Map<String, Set<String>> stations = new LinkedHashMap<>();

        stations.put("kone", new HashSet<>(Arrays.asList("id", "nv", "ut")));
        stations.put("ktwo", new HashSet<>(Arrays.asList("wa", "id", "mt")));
        stations.put("kthree", new HashSet<>(Arrays.asList("or", "nv", "ca")));
        stations.put("kfour", new HashSet<>(Arrays.asList("nv", "ut")));
        stations.put("kfive", new HashSet<>(Arrays.asList("ca", "az")));

        Set finalStations = new HashSet();

        while (!statesNeeded.isEmpty()){
            String bestStation = null;
            Set statesCovered = new HashSet();
            for(Map.Entry<String, Set<String>> station : stations.entrySet()){
                Set covered = new HashSet<>(statesNeeded);
                covered.retainAll(station.getValue());

                if(covered.size() > statesCovered.size()){
                    bestStation = station.getKey();
                    statesCovered = covered;
                }
            }

            statesNeeded.removeIf(statesCovered::contains);

            if(bestStation != null){
                finalStations.add(bestStation);
                System.out.println("best:::" + bestStation);
                System.out.println("final stations:::" + finalStations.toString());
            }
        }
        System.out.println(finalStations);

    }
}
