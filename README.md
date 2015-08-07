# MC-SkillPoints
A Minecraft mod that adds a skill and perk system to the game. This mod is very based off of my experiences playing Skyrim and Fallout. This mod is currently in its theoretical stage. It will add a very easy to use and fully-featured API for easy mod compatbility, as well as quick development of new features. 

Shoutout to kingluke_ (bae) for helping me with ideas and names, and showing me Skyrim and Fallout.

When complete, wiki will be available at the FTB Official Wiki/Gamepedia, at whatever name we decide to go with.

# About
## Skills
Each skill (described below) has its own skill tree, and can level up with use. Higher skill levels allow for the enabling of different perks, but also (depending on the skill) can make the game more difficult. Any perk can be chosen when the player levels up in that skill, but some can only be chosen at certain levels. There is a level cap of 100. Some perks have their own perk prequesites that are required to have before they can be chosen. Each skill has the same amount of perks.

When a player levels up, it will state in the chat "*user* has leveled up in the *skill* skill!" Stating this globally will be enabled by default, but disableable for large servers.

More skills may be added. Perks and skills are subject to different names and values. Names are not my strongest suit.
### Skill: Melee Combat
The skill of fighting using axes and swords. Perks:
* Swift swinger: Weapons are swung 15% faster, but critical hits are less likely.
* Critical damage: +10% chance for critical damage of up to +4 points.
* Heavy hitter: Attacks do +10 more damage, but are 20% slower.
* Strongarm: Attacks do +5 more damage.
* Crusher: Attacks ignore 10% armor ratings.

### Skill: Archery Combat
The skill of fighting using bows and arrows. Perks:
* Sharpshooter: Pressing *sharpshooter key* while an arrow is drawn will zoom in.
* Critical damage: 10% for critical damage of up to +4 points.
* Hard arrows: Attacks do +7 more damage, but draw 15% slower.
* Piercer: Attacks ignore 10% armor ratings.
* Quick draw: Draw arrows 20% faster, but are less accurate with a chance of moving slightly to the side.

### Skill: Fishing
The skill of using a fishing rod to find fish in water. Perks:
* Better bait: Higher chance of a fish biting.
* 2 fish 1 rod: 10% chance of catching 2x as many fish.
  * 3 fish 1 rod: 10% chance of catching 3x as many fish. (High level)
* Quick cast: Fishing rods cast faster
* Treasure fishing: Small chance of getting random enchanted items and valueable materials (requires 25 looting), lowers chance of catching fish.

### Skill: Mining
The skill of using a pickaxe to obtain resources. Perks:
* XP farmer: Get more experience when mining ores that give XP.
* Fortune miner: Small chance of getting extra materials from mining. Does not apply to diamonds.
  * Diamond miner: 2x diamond drops, but 2x durability use.
* Quick smash: Blocks break 20% faster.
* Hidden resouces: Small chance of finding nuggets (iron, gold, and added ones like coal, emerald, and diamond) in stone blocks.

### Skill: Enchanting
The skill of enchanting items. Perks:
* Double enchantment: 10% chancce of getting a lower-level enchantment along with the main one.
* Experience whore: Enchating costs 15% less experience, but have a small chance of being slightly less strong.
* Super armor enchanter: New armor enchantments are 10% stronger (Medium level).
  * Now for the rest: New non-armor enchantments are 10% stronger (High level).
* Save the leftovers: Enchanting gives a small amount of experience back to the player.

### Skill: Smithing
The skill of repairing and naming items with an Anvil. Perks:
* Stronger metals: Materials repair 5% more of the damage.
* Experience whore: Smithing with an Anvil costs 15% less experience, but slightly damage the item if it has more than 100 base durability.
* Delicate touch: Smithing damages the Anvil less.
* Golden touch: Repairing golden tools with blockGolds increases their base durability and damage to be better than iron.
* Instant gratification: One material repairs the entire item's durability, but costs 6% more experience.

### Skill: Farming
The skill of farming crops and breeding animals. Perks:
* Farm feeler: Slight chance for bred animals to produce twins.
* Green thumb: Get more seeds from breaking grass and harvesting crops.
* Quick grow: Higher chance that bone meal actually does shit.
* Potato friendly: Less poison potatoes!
* Animal whisperer: Uses less materials to tame an animal.

### Skill: Looting
The skill of finding dungon loot and obtaining mob drops. Perks:
* Experience licker: 20% more experience when killing mobs.
  * Ew, you lick spawners too?: Twice as much experience when spawners are broken.
* Loot master: Much, much better dungeon loot (Requires maximum level).
* Masturbutcher: Higher amount of drops from killing passives and neutrals, but 15% less experience.
  * Suck 'em dry: Higher amount of drops from killing hostiles, but 15% less experience.

### Skill: Speech (Trading)
The skill of trading with villagers (and, with Witchery, animals and demons). Perks:
* Silver tongue: Better first-time trade costs.
* Trading company: More tradeable items, as defined in the config file (with default values, of course).
* Killing is my business: Killing villagers drops a random item that they can normally trade. Includes items added by Trading Company if that perk is enabled.
* General goods: Player can trade any type of item to any type of villager, but costs slightly more.
* Always open: Villagers will never run out of stock (requires maximum level).

### Skill: Brewing
The skill of creating and using potions. Perks:
* Brew bag: Potions stack to 16.
* Where'd that bottle come from?: Slight chance to make an extra potion.
* Higher ABV: Potions are stronger in both duration and effect, but 5% chance to get nausea, hunger, and/or blindness.
* Sticky weapons: Crafting a potion with a weapon gives its effect to the weapon for one hit, causing the effect to be transferred to the attackee, like a splash potion. Works with both splash and normal potions.
* Anti-poison: 50% Resistance to thrown poisons (level 75).

### Skill: Block
The skill of using a weapon to block attacks. Perks:
* Block unarmed: Unarmed attacks are blocked by 30%.
* Block armed: Armed attacks (melee and archery) are blocked by 30%.
* Block spider bites: Spider bites are blocked by 30%.
  * Block poison bites: 50% resistance to poisonous spider bites when blocked.
* Block booms: Explosions are blocked by 30%.
