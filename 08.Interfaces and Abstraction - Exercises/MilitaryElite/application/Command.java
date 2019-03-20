package MilitaryElite.application;

import MilitaryElite.common.MissionImpl;
import MilitaryElite.common.RepairImpl;
import MilitaryElite.enumerations.Corp;
import MilitaryElite.enumerations.State;
import MilitaryElite.interfaces.Mission;
import MilitaryElite.interfaces.Private;
import MilitaryElite.interfaces.Soldier;
import MilitaryElite.models.*;

import java.util.List;

public class Command {

    private final Army ARMY = new Army();

    public Army getARMY() {
        return ARMY;
    }

    public void execute(String command, List<String> tokens) {

        int id = Integer.parseInt(tokens.get(0));
        String firstName = tokens.get(1);
        String lastName = tokens.get(2);

        Soldier soldier = null;

        switch (command) {
            case "Private":
                soldier = new PrivateImpl(id,
                        firstName,
                        lastName,
                        Double.parseDouble(tokens.get(3)));
                break;
            case "LeutenantGeneral":
                soldier = new LeutenantGeneralImpl(id, firstName, lastName,
                        Double.parseDouble(tokens.get(3)));
                int[] ids = tokens.stream().skip(4).mapToInt(Integer::parseInt)
                        .toArray();
                for (int currentId : ids) {
                    for (int i = 0; i < this.getARMY().getSoldiers().size(); i++) {
                        if (this.getARMY().getSoldiers().get(i) instanceof Private) {
                            if (this.getARMY().getSoldiers().get(i).getId() == currentId) {
                                ((LeutenantGeneralImpl) soldier).addPrivate((Private) this.getARMY().getSoldiers().get(i));
                            }
                        }
                    }
                }
                break;
            case "Engineer": {
                String corps = tokens.get(4);
                if (Corp.Airforces.toString().equals(corps) || Corp.Marines.toString().equals(corps)) {
                    soldier = new EngineerImpl(id, firstName, lastName, Double.parseDouble(tokens.get(3)),
                            Corp.valueOf(corps));

                    String[] repairData = tokens.stream().skip(5).toArray(String[]::new);

                    for (int i = 0; i < repairData.length; i += 2) {
                        String name = repairData[i];
                        int workHours = Integer.parseInt(repairData[i + 1]);
                        RepairImpl repair = new RepairImpl(name, workHours);
                        ((EngineerImpl) soldier).addRepair(repair);
                    }
                }
                break;
            }
            case "Commando": {
                String corps = tokens.get(4);
                if (Corp.Airforces.toString().equals(corps) || Corp.Marines.toString().equals(corps)) {
                    soldier = new CommandoImpl(id, firstName, lastName, Double.parseDouble(tokens.get(3)),
                            Corp.valueOf(corps));

                    String[] missionData = tokens.stream().skip(5).toArray(String[]::new);

                    for (int i = 0; i < missionData.length; i += 2) {
                        String name = missionData[i];
                        String state = missionData[i + 1];
                        if (State.Finished.toString().equals(state) || State.inProgress.toString().equals(state)) {
                            Mission mission = new MissionImpl(name, State.valueOf(state));
                            ((CommandoImpl) soldier).addMission(mission);
                        }
                    }
                }
                break;
            }
            case "Spy":
                soldier = new SpyImpl(id, firstName, lastName, tokens.get(3));
                break;
        }

        if (soldier != null) {
            this.getARMY().addSoldier(soldier);
        }
    }
}
