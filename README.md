# 99.7% Citric Liquid
Readme in "spanglish", by Diego Vergara V.
## About

`99.7% Citric Liquid` is a simplified clone of the renowned game, `100% Orange Juice`. Its main
purpose is to serve as an educational tool, teaching foundational programming concepts.

📢 **Note**: This project is purely educational and will not be used for any commercial purposes.

---

### To the Teaching Team <3:
I'm sorry for doing so bad in the first homework. I really like this course and I wholeheartedly appreciate the work (and overwork) you guys and girls are putting into this sinking ship of a generation.
I hope that this homework is up to the expected standards.


## Design Choices!!!!!

- For Tarea 2 - EF:
    -All terminal inputs have been removed
    -About Stars when a unit is defeated: the KO() function for Units calculates and returns the corresponding amount of Stars. Wins is always increased by 2 or 1 depending on the type of the defeated unit. This will be implemented on the Battle function using Double Dispatch on the Unit's type.

For Norma:
        
    -As sugested by the teaching team <3, Norma has been implemented as a trait and each level as a unique class with the concerning attributes.
    
    -Norma does not currently have implemented a variable for the condition chosen by the player, so it just checks both.

For PlayerCharacter:
        
    -NormaClear() has been merged into NormaCheck().
            
    -NormaCondition has been removed. Now Norma's functionality is fully capable of modifying itself accordingly (instead of relying on PlayerCharacter's paramaters).
        

For WildUnitAbstract.
        
    -WildUnit has been replaced by WildUnitAbstract
    
    -The different type of Wild Units no longer share a functional constructor, now they are unique classes on their own.

    -KO() function return the corresponding amount of stars upon being defeated. The assignation of stars will be made within the controller with the setWins and setStars setters from PlayerCharacter.
        From PanelAbstract.
            -Panel has been replaced by PanelAbstract

For Panels:

    -Attribute panelType for PanelAbstract has been removed since it was redundant


-For Tarea 2 - EP 4:
    The effects for Bonus Panel and Drop Panel have been added in the stop() function. EQUIVALENT TO def apply().

-All trait, abstract classes and class parameters are defined as "var". This is to support further 
modification of these values along the development of the Tarea (Example: ATK Buff)


<div style="text-align:center;">
    <img src="https://i.creativecommons.org/l/by/4.0/88x31.png" alt="Creative Commons License">
</div>

This project is licensed under the [Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/).

---