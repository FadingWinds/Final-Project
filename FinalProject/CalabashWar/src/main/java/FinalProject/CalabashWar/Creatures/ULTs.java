package FinalProject.CalabashWar.Creatures;

//The ULTs of everyone except the underlings(who don't have any ULTs).
public enum ULTs {
    //The ULTs of Calabash Brothers. Each ULT is privately belong to a Calabash Brother.
    STOUTER("The ULT of the 1st Calabash Brother(Passive Skill)." +
            "Add the maxATK and minATK by 50 for himself."),
    GOOD_SIGHT_AND_HEARING("The ULT of the 2nd Calabash Brother(Passive Skill)." +
            "Able to detect an enemy from about twice the normal distance and fight."),
    INVULNERABILITY("The ULT of the 3rd Calabash Brother(Passive Skill)." +
            "Add the HP by 300 for himself."),
    FIRE("The ULT of the 4th Calabash Brother(Active Skill)." +
            "Use fire(ATK:233) to attack the enemy once 3 rounds."),
    WATER("The ULT of the 5th Calabash Brother(Active Skill)." +
            "Use water(ATK:233) to attack the enemy once 3 rounds."),
    INVISIBLE("The ULT of the 6th Calabash Brother(Passive Skill)." +
            "Skip an attack at the chances of 30% every round in a fight."),
    MAGIC_CALABASH("The ULT of the 7th Calabash Brother(Active Skill)." +
            "Kill an enemy who isn't in a fight and has HP below 300 wherever the Calabash Brother is." +
            "Only available once in a war."),

    //The ULT of Grandpa which is privately belong to Grandpa.
    COLORFUL_LOTUS("The ULT of Grandpa(Active Skill)." +
            "Call every alive Calabash Brother to attack an enemy once at minATK." +
            "Only available once in a war."),

    //The ULTs of Scorpion and Snake which can be used by either of them.
    MAGIC_MIRROR("The ULT of Scorpion/Snake(Passive Skill)." +
            "Add its own HP at 15% of the total of every alive enemy's HP." +
            "Only available 3 times in a war after the war has begin for a while."),
    AS_WISH("The ULT of Scorpion/Snake(Active Skill)." +
            "Attack every alive enemy once at maxATK wherever the Scorpion/Snake is if all the underlings are dead." +
            "Only available once in a war."),
    YIN_YANG_SWORD("The ULT of Scorpion/Snake(Active Skill)." +
            "Use Sword(ATK:250) once 2 rounds to attack the 3rd Calabash Brother if in a fight with him."),
    POISONOUS_WINE("The ULT of Scorpion/Snake(Active Skill)." +
            "10% chances of attacking the 4th & 5th Calabash Brother at minATK wherever the Scorpion/Snake is when creatures move.")
    ;

    private String description;

    ULTs(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
