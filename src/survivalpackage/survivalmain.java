package survivalpackage;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.sound.midi.Receiver;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Particle.DustOptions;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.block.data.Openable;
import org.bukkit.block.data.Waterlogged;
import org.bukkit.block.data.Bisected.Half;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_14_R1.CraftServer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.DragonFireball;
import org.bukkit.entity.Drowned;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Evoker;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Husk;
import org.bukkit.entity.Illager;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Item;
import org.bukkit.entity.LargeFireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Llama;
import org.bukkit.entity.LlamaSpit;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Raider;
import org.bukkit.entity.Ravager;
import org.bukkit.entity.Shulker;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.SkeletonHorse;
import org.bukkit.entity.Slime;
import org.bukkit.entity.SmallFireball;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Stray;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wither;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.entity.WitherSkull;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.event.player.PlayerFishEvent.State;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.loot.LootContext;
import org.bukkit.loot.LootContext.Builder;
import org.bukkit.loot.LootTable;
import org.bukkit.loot.Lootable;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;
import org.bukkit.scoreboard.Team.Option;
import org.bukkit.scoreboard.Team.OptionStatus;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;
import org.spigotmc.event.entity.EntityMountEvent;

import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.EntityPose;
import me.libraryaddict.disguise.disguisetypes.FlagWatcher;
import me.libraryaddict.disguise.disguisetypes.PlayerDisguise;
import me.libraryaddict.disguise.disguisetypes.watchers.PlayerWatcher;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class survivalmain extends JavaPlugin implements Listener, CommandExecutor{

	public static survivalmain instance;
	public ConsoleCommandSender console = getServer().getConsoleSender();
	Random randor = new Random();
	public World wor = null;
	FileConfiguration config = getConfig();
	BukkitScheduler scheduler = null;
	public ArrayList<String> worlds = new ArrayList<String>();
	public HashMap<Player, Integer> thirst = new HashMap<Player, Integer>();
	public HashMap<String, Integer> thirstN = new HashMap<String, Integer>();
	public List<String> whitelist = new ArrayList<String>();
	
	public List<String> limbo = new ArrayList<String>();
	public HashMap<Integer, List<Location>> parkour = new HashMap<Integer, List<Location>>();
	int killsDivider = 10;
	public HashMap<String, Integer> kills = new HashMap<String, Integer>();
	
	public HashMap<String, String> usernames = new HashMap<String, String>();
	public List<String> firstnames = new ArrayList<String>();
	public List<String> lastnames = new ArrayList<String>();
	
	int monsterViewDistance = 64;
	
	public HashMap<String, String> playerFakes = new HashMap<String, String>();
	List<String> playersInArtifact = new ArrayList<String>();
	
	Location regionLoc1 = null;
	Location regionLoc2 = null;
	Location parkourP1 = null;
	Location parkourP2 = null;
	
	boolean limboE = false;
	boolean nametagE = false;
	boolean deathMessageE = false;
	boolean bloodE = false;
	boolean crawlingE = false;
	boolean detectionE = false;
	boolean chatE = false;
	boolean thirstE = false;
	boolean cropsE = false;
	boolean fireE = false;
	boolean dropsE = false;
	boolean monstersE = false;
	boolean fallE = false;
	boolean headshotsE = false;
	boolean desirePathE = false;
	boolean headE = false;
	boolean stageE = false;
	boolean leavesE = false;
	boolean colorE = false;
	boolean namesE = false;
	boolean npcE = false;
	boolean timeE = false;
	boolean potionE = false;
	boolean joinE = false;
	boolean leaveE = false;
	boolean bloodDropsE = false;
	boolean artifactsE = false;
	
	Scoreboard hide = null;
	
	/////////////////////////////////////////////////////
	public shopGUIS shopGUIS = new shopGUIS();

	static HashMap<Player, ArrayList<Entity>> diamondm = new HashMap<Player, ArrayList<Entity>>();
	
	HashMap<String, Integer> playertimes = new HashMap<String, Integer>();
	HashMap<Player, String> discs = new HashMap<Player, String>();
	HashMap<Player, Float> pitches = new HashMap<Player, Float>();
	HashMap<String, Integer> discnames = new HashMap<String, Integer>();
	
	List<Color> colors = new ArrayList<Color>();
	
	public HashMap<String, Float> velocityPower = new HashMap<String, Float>();
	public HashMap<String, Float> attackPower = new HashMap<String, Float>();
	public HashMap<String, Float> strengthPower = new HashMap<String, Float>();
	public HashMap<String, Float> magicPower = new HashMap<String, Float>();
	public HashMap<String, Float> resisPower = new HashMap<String, Float>();
	public HashMap<String, Float> reachPower = new HashMap<String, Float>();
	public HashMap<String, Float> scopePower = new HashMap<String, Float>();
	
	HashMap<String,PlayerCountDown> jumpcd = new HashMap<String,PlayerCountDown>();

	public List<String> mn = new ArrayList<String>();
	
	public boolean canErase = true;
	
	public blockSounds bs = null;
	
	String larry = null;
	
	int spawndistance = 100;
	
	List<String> lickers = new ArrayList<String>();
	////////////////////////////////////////////////////
	
	@Override
	public void onEnable() {
		instance = this;
		addnames();
		boolean configed = false;
		createConfigFol();
		this.getServer().getPluginManager().registerEvents(this, this);
		scheduler = getServer().getScheduler();
		loadConfigs();
		ArrayList<String> tworlds = (ArrayList<String>) config.getList("Enabled Worlds - If Left Blank Will Just Use default world ");
		for(String w : tworlds) {
			if(w.equals("placeholder1")||w.equals("placeholder2")) {
				
			}
			else {
				worlds.add(w);
			}
		}
		if(worlds.size()==0) {
			boolean hasWorldR = false;
			for(World w : Bukkit.getWorlds()) {
				if(w.getName().equals("world")) {
					hasWorldR = true;
				}
			}
			if(hasWorldR == true) {
				worlds.add("world");
			}
			else {
			worlds.add(Bukkit.getWorlds().get(0).getName());
			}
		}
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(artifactsE) {
				if(!shopGUIS.enabled.containsKey(p.getName())) {
					shopGUIS.enabled.put(p.getName(), new ArrayList<Integer>());
				}
			}
			if(thirstE == true) {
			if(!thirst.containsKey(p)) {
				thirst.put(p, 100);
				thirstN.put(p.getName(), 100);
			}
			}
			if(limboE == true) {
			if(!kills.containsKey(p.getName())) {
				kills.put(p.getName(), 0);
			}
			}
			if(namesE == true) {
			if(!usernames.containsKey(p.getName())) {
				usernames.put(p.getName(), getRandomName());
			}
			}
		}
		for(Player p : Bukkit.getOnlinePlayers()) {
			PlayerCountDown cd = new PlayerCountDown(p.getName());
			jumpcd.put(p.getName(), cd);
			if(!magicPower.containsKey(p.getName())) {
				magicPower.put(p.getName(), (float) 1);
			}
			if(!velocityPower.containsKey(p.getName())) {
				velocityPower.put(p.getName(), (float) .85);
			}
			if(!attackPower.containsKey(p.getName())) {
				attackPower.put(p.getName(), (float) 1);
			}
			if(!strengthPower.containsKey(p.getName())) {
				strengthPower.put(p.getName(), (float) 1);
			}
			if(!reachPower.containsKey(p.getName())) {
				reachPower.put(p.getName(), (float) .01);
			}
			if(!scopePower.containsKey(p.getName())) {
				scopePower.put(p.getName(), (float) .2);
			}
			if(!resisPower.containsKey(p.getName())) {
				resisPower.put(p.getName(), (float) .001);
			}
			if(!shopGUIS.enabled.containsKey(p.getName())) {
				shopGUIS.enabled.put(p.getName(), new ArrayList<Integer>());
			}
		}
		
		if(worlds.size() > 0) {
		World w = Bukkit.getWorld(worlds.get(0));
		if(w != null) {
		larry = w.spawnEntity(w.getSpawnLocation(), EntityType.LLAMA).getUniqueId().toString();
		if(Bukkit.getEntity(UUID.fromString(larry)) != null) {
		Bukkit.getEntity(UUID.fromString(larry)).setInvulnerable(true);
		((Llama) Bukkit.getEntity(UUID.fromString(larry))).setRemoveWhenFarAway(false);
		addPotionEffectBetter(((Llama) Bukkit.getEntity(UUID.fromString(larry))), PotionEffectType.SLOW, 999999, 150, false, false, false);
		}
		}
		}
		bs = new blockSounds();
		spawndistance = config.getInt("Spawn Radius ");
		addToWhitelist();
		scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				saveConfigs();
				playersInArtifact.clear();
			}
		}, 0L, 10000L);
		scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				if(crawlingE) {
				crawlLoop();
				}
				if(fireE) {
				fireLoop();
				}
				if(artifactsE) {
					artifactInsideEffect();
					increaseWaterVelocity();
					activateDoor();
				}
				effectLooperF();
			}
		}, 0L, 1L);
		scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				if(thirstE) {
				decreaseThirst();
				}
			}
		}, 0L, 500L);
		scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				if(thirstE) {
				thirstEffects();
				heartBeatSound();
				}
				if(monstersE) {
				doCreeperEffects();
				}
				if(potionE) {
				addPotionEffectsArmor();
				}
				if(artifactsE) {
					regenPlayers();
				}
				iterateRadio();
			}
		}, 0L, 20L);
		scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				if(timeE) {
				World tempworld = Bukkit.getWorld(worlds.get(0));
				tempworld.setFullTime(tempworld.getFullTime()-2);
				}
			}
		}, 0L, /* 600 */3L);
		scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				effectLooper();
			}
		}, 0L, 2L);

		doScoreboardThing();
	}

	@Override
	public void onDisable() {
		saveConfigs();
		Entity e = Bukkit.getEntity(UUID.fromString(larry));
		if(e != null) {
			e.remove();
		}
		instance = null;
	}
	
	public void createConfigFol() {
		if(!config.isBoolean("Artifacts ")) {
		console.sendMessage(ChatColor.YELLOW + "Creating Config Folder - Beep... Boop.. - Config Machine Done");
		config.addDefault("Spawn Radius ", 100);
		config.addDefault("Artifacts ", true);
		config.addDefault("monsterViewDistance ", 64);
		config.addDefault("Parkour Limbo ", false);
		config.addDefault("No Nametags ", true);
		config.addDefault("No Death Messages ", true);
		config.addDefault("Blood ", true);
		config.addDefault("Blood Drops ", true);
		config.addDefault("Crawling ", true);
		config.addDefault("Better Entity Detection ", true);
		config.addDefault("Locational Chat ", false);
		config.addDefault("Thirst ", true);
		config.addDefault("Realistic Crops ", true);
		config.addDefault("Better Entity Fire Effects ", true);
		config.addDefault("Realistic Mob Drops ", true);
		config.addDefault("Enhanced Monsters ", true);
		config.addDefault("Better Fall Damage ", true);
		config.addDefault("Headshots ", true);
		config.addDefault("Desire Paths ", true);
		config.addDefault("Any Item On Head ", true);
		config.addDefault("Multi Stage Blocks ", true);
		config.addDefault("Extra Leave Drops", true);
		config.addDefault("Coloring In Anvils ", true);
		config.addDefault("Realistic Usernames ", false);
		config.addDefault("Player NPC Left On Exit ", false);
		config.addDefault("Longer Day And Night ", true);
		config.addDefault("Potions In Anvils ", true);
		config.addDefault("No Join Messages ", false);
		config.addDefault("No Leave Messages", false);
		config.addDefault("Enable Blood Check Explosions ", false);
		config.addDefault("Force Hiding Nametags ", false);
		config.addDefault("parkourP1", "none");
		config.addDefault("parkourP2", "none");
		config.addDefault("Parkour Divider ", 10);
		config.addDefault("Velocity Power", new ArrayList<String>());
		config.addDefault("Attack Power", new ArrayList<String>());
		config.addDefault("Strength Power", new ArrayList<String>());
		config.addDefault("Magic Power", new ArrayList<String>());
		config.addDefault("Resis Power", new ArrayList<String>());
		config.addDefault("Scope Power", new ArrayList<String>());
		config.addDefault("Reach Power", new ArrayList<String>());
		List<String> enableds = new ArrayList<String>();
		config.addDefault("enabled", enableds);
		List<String> fakesA = new ArrayList<String>();
		config.addDefault("fakes", fakesA);
		List<String> namesA = new ArrayList<String>();
		config.addDefault("names", namesA);
		List<String> killsA = new ArrayList<String>();
		config.addDefault("kills", killsA);
		List<String> limbo = new ArrayList<String>();
		config.addDefault("limbo", limbo);
		List<String> parkours = new ArrayList<String>();
		config.addDefault("parkours", parkours);
		List<String> listitem2 = new ArrayList<String>();
		boolean hasWorldR = false;
		for(World w : Bukkit.getWorlds()) {
			if(w.getName().equals("world")) {
				hasWorldR = true;
			}
		}
		if(hasWorldR == true) {
			listitem2.add("world");
		}
		else {
			listitem2.add(Bukkit.getWorlds().get(0).getName());
		}
		listitem2.add("placeholder1");
		listitem2.add("placeholder2");
		config.addDefault("Enabled Worlds - If Left Blank Will Just Use default world ", listitem2);
		config.options().copyDefaults(true);
		saveConfig();
		}
	}
	
	public void loadConfigs() {
		artifactsE = config.getBoolean("Artifacts ");
		limboE = config.getBoolean("Parkour Limbo ");
		bloodDropsE = config.getBoolean("Blood Drops ");
		nametagE = config.getBoolean("No Nametags ");
		deathMessageE = config.getBoolean("No Death Messages ");
		bloodE = config.getBoolean("Blood ");
		crawlingE = config.getBoolean("Crawling ");
		detectionE = config.getBoolean("Better Entity Detection ");
		chatE = config.getBoolean("Locational Chat ");
		thirstE = config.getBoolean("Thirst ");
		cropsE = config.getBoolean("Realistic Crops ");
		fireE = config.getBoolean("Better Entity Fire Effects ");
		dropsE = config.getBoolean("Realistic Mob Drops ");
		monstersE = config.getBoolean("Enhanced Monsters ");
		fallE = config.getBoolean("Better Fall Damage ");
		headshotsE = config.getBoolean("Headshots ");
		desirePathE = config.getBoolean("Desire Paths ");
		headE = config.getBoolean("Any Item On Head ");
		stageE = config.getBoolean("Multi Stage Blocks ");
		leavesE = config.getBoolean("Extra Leave Drops");
		colorE = config.getBoolean("Coloring In Anvils ");
		namesE = config.getBoolean("Realistic Usernames ");
		npcE = config.getBoolean("Player NPC Left On Exit ");
		timeE = config.getBoolean("Longer Day And Night ");
		potionE = config.getBoolean("Potions In Anvils ");
		joinE = config.getBoolean("No Join Messages ");
		leaveE = config.getBoolean("No Leave Messages");
		List<String> parkours = new ArrayList<String>(config.getStringList("parkours"));
		for(String location : parkours) {
			getParkourLocation(location);
		}
		killsDivider = config.getInt("Parkour Divider ");
		List<String> killsA = new ArrayList<String>(config.getStringList("kills"));
		for(String kill : killsA) {
			getKills(kill);
		}
		List<String> namesA = new ArrayList<String>(config.getStringList("names"));
		for(String name : namesA) {
			getName(name);
		}
		List<String> fakesA = new ArrayList<String>(config.getStringList("fakes"));
		for(String fake : fakesA) {
			getFake(fake);
		}
		parkourP1 = getLocation(config.getString("parkourP1"));
		parkourP2 = getLocation(config.getString("parkourP2"));
		limbo = config.getStringList("limbo");
		List<String> vel = config.getStringList("Velocity Power");
		List<String> attack = config.getStringList("Attack Power");
		List<String> stren = config.getStringList("Strength Power");
		List<String> magic = config.getStringList("Magic Power");
		List<String> resis = config.getStringList("Resis Power");
		List<String> reach = config.getStringList("Reach Power");
		List<String> scope = config.getStringList("Scope Power");
		for(String s : vel) {
			try {
			String name = s.substring(0, s.lastIndexOf("^"));
			float pow = Float.parseFloat(s.substring(s.lastIndexOf("^")+1, s.length()));
			velocityPower.put(name, pow);
			}
			catch(Exception e) {
				
			}
		}
		for(String s : attack) {
			try {
			String name = s.substring(0, s.lastIndexOf("^"));
			float pow = Float.parseFloat(s.substring(s.lastIndexOf("^")+1, s.length()));
			attackPower.put(name, pow);
			}
			catch(Exception e) {
				
			}
		}
		for(String s : stren) {
			try {
			String name = s.substring(0, s.lastIndexOf("^"));
			float pow = Float.parseFloat(s.substring(s.lastIndexOf("^")+1, s.length()));
			strengthPower.put(name, pow);
			}
			catch(Exception e) {
				
			}
		}
		for(String s : magic) {
			try {
			String name = s.substring(0, s.lastIndexOf("^"));
			float pow = Float.parseFloat(s.substring(s.lastIndexOf("^")+1, s.length()));
			magicPower.put(name, pow);
			}
			catch(Exception e) {
				
			}
		}
		for(String s : resis) {
			try {
			String name = s.substring(0, s.lastIndexOf("^"));
			float pow = Float.parseFloat(s.substring(s.lastIndexOf("^")+1, s.length()));
			resisPower.put(name, pow);
			}
			catch(Exception e) {
				
			}
		}
		for(String s : reach) {
			try {
			String name = s.substring(0, s.lastIndexOf("^"));
			float pow = Float.parseFloat(s.substring(s.lastIndexOf("^")+1, s.length()));
			reachPower.put(name, pow);
			}
			catch(Exception e) {
				
			}
		}
		for(String s : scope) {
			try {
			String name = s.substring(0, s.lastIndexOf("^"));
			float pow = Float.parseFloat(s.substring(s.lastIndexOf("^")+1, s.length()));
			scopePower.put(name, pow);
			}
			catch(Exception e) {
				
			}
		}
		List<String> enabledTemp = config.getStringList("enabled");
		for(String enable : enabledTemp) {
			loadPlayerEnabled(enable);
		}
	}
	
	public void saveConfigs() {
		List<String> vel = new ArrayList<String>();
		List<String> attack = new ArrayList<String>();
		List<String> stren = new ArrayList<String>();
		List<String> magic = new ArrayList<String>();
		List<String> resis = new ArrayList<String>();
		List<String> reach = new ArrayList<String>();
		List<String> scope = new ArrayList<String>();
		HashMap<String, List<Integer>> enabledTemp = new HashMap<String, List<Integer>>(shopGUIS.enabled);
		List<String> enabledSaved = new ArrayList<String>();
		for(String name : enabledTemp.keySet()) {
			String start = name + "";
			for(Integer ability : enabledTemp.get(name)) {
				start += ("," + ability) ;
			}
			enabledSaved.add(start);
		}
		config.set("enabled", enabledSaved);
		if(!velocityPower.isEmpty()) {
		for(String name : velocityPower.keySet()) {
			String newValue = name + "^" + velocityPower.get(name);
			vel.add(newValue);
		}
		}
		if(!attackPower.isEmpty()) {
		for(String name : attackPower.keySet()) {
			String newValue = name + "^" + attackPower.get(name);
			attack.add(newValue);
		}
		}
		if(!strengthPower.isEmpty()) {
		for(String name : strengthPower.keySet()) {
			String newValue = name + "^" + strengthPower.get(name);
			stren.add(newValue);
		}
		}
		if(!magicPower.isEmpty()) {
		for(String name : magicPower.keySet()) {
			String newValue = name + "^" + magicPower.get(name);
			magic.add(newValue);
		}
		}
		if(!resisPower.isEmpty()) {
		for(String name : resisPower.keySet()) {
			String newValue = name + "^" + resisPower.get(name);
			resis.add(newValue);
		}
		}
		if(!reachPower.isEmpty()) {
			for(String name : reachPower.keySet()) {
				String newValue = name + "^" + reachPower.get(name);
				reach.add(newValue);
		}
		}
		if(!scopePower.isEmpty()) {
			for(String name : scopePower.keySet()) {
				String newValue = name + "^" + scopePower.get(name);
				scope.add(newValue);
		}
		}
		if(config.contains("Velocity Power")) {
		config.set("Velocity Power", vel);
		}
		if(config.contains("Attack Power")) {
		config.set("Attack Power", attack);
		}
		if(config.contains("Strength Power")) {
		config.set("Strength Power", stren);
		}
		if(config.contains("Magic Power")) {
		config.set("Magic Power", magic);
		}
		if(config.contains("Resis Power")) {
		config.set("Resis Power", resis);
		}
		if(config.contains("Reach Power")) {
			config.set("Reach Power", reach);
		}
		if(config.contains("Scope Power")) {
			config.set("Scope Power", scope);
		}
		saveKills();
		saveNames();
		saveFakes();
		saveConfig();
	}
	
	public void loadPlayerEnabled(String abilities) {
		if(abilities == null) {
    		return;
    	}
    	String[] split = abilities.split(",");
    	List<Integer> enabled = new ArrayList<Integer>();
    	String name = split[0];
    	for(int count = 1; count < split.length; count++) {
    		enabled.add(Integer.parseInt(split[count]));
    	}
    	shopGUIS.enabled.put(name, enabled);
	}
	
	@EventHandler
	public void onPlayerJoinFirst(PlayerJoinEvent e) {
		String playername = e.getPlayer().getName();
		if(!(shopGUIS.enabled.containsKey(playername))) {
			List<Integer> list = new ArrayList<Integer>();
			shopGUIS.enabled.put(playername, list);
		}
	}
	
	public int coinFlip() {
    	if(randor.nextBoolean() == true) {
    		return 1;
    	}
    	else {
    		return -1;
    	}
    }
	
	public boolean isNight(World w) {
		if(w.getTime()>12500&&w.getTime()<22900) {
			return true;
		}
		return false;
	}
	
	public void healPlayer(Player p, double ammount) {
		double currenthealth = p.getHealth();
		if(currenthealth + ammount >= p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()) {
			p.setHealth(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
		}
		else {
			p.setHealth(currenthealth + ammount);
		}
	}
	
	public void feedPlayer(Player p, double ammount) {
		double currentfood = p.getFoodLevel();
		if(currentfood + ammount >= 20) {
			p.setFoodLevel(20);
		}
		else {
			p.setFoodLevel((int) (currentfood + ammount));
		}
	}

	public void addPotionEffectBetter(LivingEntity e, PotionEffectType pt, int duration, int amp, boolean ambient, boolean hp, boolean additive) {
		if(e.hasPotionEffect(pt)) {
			int level = amp;
			if(additive == true) {
				level = e.getPotionEffect(pt).getAmplifier() + (amp+1);
			}
			if(level < 200) {
			e.removePotionEffect(pt);
			e.addPotionEffect(new PotionEffect(pt, duration, level, ambient, hp));
			}
			else {
				e.removePotionEffect(pt);
				e.addPotionEffect(new PotionEffect(pt, duration, 200, ambient, hp));
			}
		}
		else {
			e.addPotionEffect(new PotionEffect(pt, duration, amp, ambient, hp));
		}
	}

	public boolean isAir(Material m) {
		if(m == Material.AIR || m == Material.CAVE_AIR || m == Material.VOID_AIR) {
			return true;
		}
		return false;
	}
	
	public boolean isStony(Material m) {
		if(m == Material.STONE || m == Material.MOSSY_COBBLESTONE || m == Material.ANDESITE || m == Material.DIORITE || m == Material.COBBLESTONE || m == Material.GRANITE || m == Material.GRAVEL) {
			return true;
		}
		return false;
	}
	
	public boolean getAboveGround(Location l) {
		boolean above = false;
		if(l.getBlock().getType()==Material.AIR||l.getBlock().getType()==Material.WATER) {
			if(l.getBlock().getLightFromSky()>0) {
				if(l.getY() >= 45) {
					above = true;
				}
			}
		}
		return above;
	}
	
	public Location getRandLoc(Location l, int radi) {
		if(l!=null) {
		double radius = radi;
		double x0 = l.getX();
		double y0 = l.getY();
		double z0 = l.getZ();
			   double u = Math.random();
			   double v = Math.random();
			   double theta = 2 * Math.PI * u;
			   double phi = Math.acos(2 * v - 1);
			   double x = x0 + (radius * Math.sin(phi) * Math.cos(theta));
			   double y = y0 + (radius * Math.sin(phi) * Math.sin(theta));
			   double z = z0 + (radius * Math.cos(phi));
			   return new Location(l.getWorld(), x, y, z, randor.nextInt(360), randor.nextInt(360));
		}
		return null;
	}
	
	public void addToWhitelist() {
		whitelist.add("grass");
		whitelist.add("sand");
		whitelist.add("gravel");
		whitelist.add("wool");
		whitelist.add("mycel");
		whitelist.add("powder");
		whitelist.add("clay");
		whitelist.add("leave");
		whitelist.add("hay");
		whitelist.add("snow");
		whitelist.add("sponge");
	}
	
    public void addStringofParkourLocation(Location loc, int difficulty){
    	if(parkour.containsKey(difficulty)) {
    		parkour.get(difficulty).add(loc);
    	}
    	else {
    		List<Location> parkourDifficulty = new ArrayList<Location>();
    		parkour.put(difficulty, parkourDifficulty);
    		parkour.get(difficulty).add(loc);
    	}
    	String saved = loc.getBlockX() + "," + loc.getBlockY() + "," + loc.getBlockZ() + "," + loc.getWorld().getName() + "," + difficulty;
    	List<String> parkours = new ArrayList<String>(config.getStringList("parkours"));
    	parkours.add(saved);
    	config.set("parkours", parkours);
    	saveConfig();
    }
    
    public void getParkourLocation(String what){
    	if(what == null) {
    		return;
    	}
    	String[] split = what.split(",");
    	if(split.length < 5) {
    		return;
    	}
    	Location loc = new Location(Bukkit.getWorld(split[3]), Double.parseDouble(split[0]), Double.parseDouble(split[1]), Double.parseDouble(split[2]));
    	int difficulty = Integer.parseInt(split[4]);
    	if(parkour.containsKey(difficulty)) {
    		parkour.get(difficulty).add(loc);
    	}
    	else {
    		List<Location> parkourDifficulty = new ArrayList<Location>();
    		parkour.put(difficulty, parkourDifficulty);
    		parkour.get(difficulty).add(loc);
    	}
    }
    
    public void addKill(String name, int ammount) {
    	if(kills.containsKey(name)) {
    		int killA = kills.get(name) + ammount;
    		kills.put(name, killA);
    	}
    	else {
    		kills.put(name, ammount);
    	}
    }
    
    public void getKills(String what){
    	if(what == null) {
    		return;
    	}
    	String[] split = what.split(",");
    	if(split.length < 2) {
    		return;
    	}
    	String name = split[0];
    	int killsA = Integer.parseInt(split[1]);
    	kills.put(name, killsA);
    }
	
    public void saveKills() {
    	List<String> full = new ArrayList<String>();
    	HashMap<String, Integer> killsCopy = new HashMap<String, Integer>(kills);
    	for(String name : killsCopy.keySet()) {
    		String complete = name + "," + killsCopy.get(name);
    		full.add(complete);
    	}
    	config.set("kills", full);
    	saveConfig();
    }
    
    public void addToLimbo(String name) {
    	limbo.add(name);
    	config.set("limbo", limbo);
    	saveConfig();
    }
    
    public void removeLimbo(String name) {
    	limbo.remove(name);
    	config.set("limbo", limbo);
    	saveConfig();
    }
    
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("lick")) {
			if(args != null) {
				if(args.length>0 && args.length<2) {
					String name = args[0];
				if(sender instanceof Player) {
					Player p = (Player) sender;
					String pname = p.getName();
					if(lickers.contains(pname)) {
						p.sendMessage(ChatColor.YELLOW + "Sorry, you must wait 5 seconds before licking again :c.");
					}
					else {
						Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "" + pname + " licked " + name + ".");
						lickers.add(pname);
						Bukkit.getScheduler().runTaskLater(this, () -> lickers.remove(pname), 100);	
					}
				}
				else {
					String pname = "other";
					if(lickers.contains(pname)) {
						sender.sendMessage(ChatColor.YELLOW + "Sorry, you must wait 5 seconds before licking again :c.");
					}
					else {
						Bukkit.broadcastMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "" + pname + " licked " + name + ".");
						lickers.add(pname);
						Bukkit.getScheduler().runTaskLater(this, () -> lickers.remove(pname), 100);	
					}
				}
				}
			}
			return true;
		}
		if (sender instanceof Player) {
		Player p = ((Player) sender);
			if (command.getName().equalsIgnoreCase("placeholder")) {
				thirst.put(p, 20);
				return true;
			}
			if (command.getName().equalsIgnoreCase("parkouradd")) {
				if(args == null) {
					Location l = p.getLocation().add(0, 0.1, 0);
					int difficulty = 0;
					addStringofParkourLocation(l, difficulty);
					p.sendMessage(ChatColor.GREEN + "Added parkour with difficulty of " + difficulty);
					return true;
				}
				if(args.length==0) {
					Location l = p.getLocation().add(0, 0.1, 0);
					int difficulty = 0;
					addStringofParkourLocation(l, difficulty);
					p.sendMessage(ChatColor.GREEN + "Added parkour with difficulty of " + difficulty);
				}
				else {
					Location l = p.getLocation().add(0, 0.1, 0);
					int difficulty = Integer.parseInt(args[0]);
					addStringofParkourLocation(l, difficulty);
					p.sendMessage(ChatColor.GREEN + "Added parkour with difficulty of " + difficulty);
				}
				return true;
			}
			if (command.getName().equalsIgnoreCase("radio")) {
				if(shopGUIS.enabled.get(p.getName()).contains(147)) {
				if(args != null) {
					if(args.length >= 1 && args.length < 3) {
						if(args.length==1) {
							if(playertimes.containsKey(p.getName())) {
								playertimes.remove(p.getName());
								discs.remove(p);
								pitches.remove(p);
							}
							for(String disctype : discnames.keySet()) {
								p.stopSound(Sound.valueOf("RECORD_" + disctype.toUpperCase()));
							}
							p.sendMessage(ChatColor.LIGHT_PURPLE + "Stopped your radio!");
							return true;
						}
						else {
							String discname = args[0];
							float pitch = Float.parseFloat(args[1]);
							if(!(pitch <= 2 && pitch >= 0)) {
								p.sendMessage(ChatColor.DARK_PURPLE + "Sorry! The pitch must be inbetween 0 and 2. Example : 1.3, 0.1, 0.8");
								return true;
							}
							if(!discnames.containsKey(discname)) {
								p.sendMessage(ChatColor.DARK_PURPLE + "Sorry! That is not a valid track name. Example : cat, 13, stal, ward");
								return true;
							}
							for(String disctype : discnames.keySet()) {
								p.stopSound(Sound.valueOf("RECORD_" + disctype.toUpperCase()));
							}
							playertimes.put(p.getName(), 0);
							discs.put(p, discname);
							pitches.put(p, pitch);
							p.playSound(p.getLocation(), Sound.valueOf("RECORD_" + discname.toUpperCase()), 100, pitch);
							p.sendMessage(ChatColor.LIGHT_PURPLE + "Track " + discname + " at pitch " + pitch + " has been started on the radio.");
							p.sendMessage(ChatColor.LIGHT_PURPLE + "Thank you for using the radio today!");
							return true;
						}
					}
				}
				p.sendMessage(ChatColor.DARK_PURPLE + "Sorry, incorrectly typed! To use the radio do /radio title pitch(0.0 to 2.0) or /radio stop");
				}
				return true;
			}
			if (command.getName().equalsIgnoreCase("parkourdivider")) {
				if(args == null) {
					p.sendMessage(ChatColor.RED + "Needs a number!");
					return true;
				}
				if(args.length==0) {
					p.sendMessage(ChatColor.RED + "Needs a number!");
				}
				else {
					int divide = Integer.parseInt(args[0]);
					killsDivider = divide;
					config.set("Parkour Divider ", divide);
					saveConfig();
					p.sendMessage(ChatColor.GREEN + "Set parkour divider to " + divide);
				}
				return true;
			}
			else if (command.getName().equalsIgnoreCase("rpointp")) {
				if(args[0].equals("1")) {
					regionLoc1 = p.getLocation().subtract(0, 1, 0);
					p.sendMessage(ChatColor.GREEN + "Point 1 set to block below player.");
				}
				else {
					regionLoc2 = p.getLocation().subtract(0, 1, 0);
					p.sendMessage(ChatColor.GREEN + "Point 2 set to block below player.");
				}
				return true;
			}
			
			else if (command.getName().equalsIgnoreCase("definerp")) {
				if(regionLoc1 == null || regionLoc2 == null) {
					p.sendMessage(ChatColor.RED + "Missing region corner!");
					return true;
				}
				parkourP1 = regionLoc1.clone();
				parkourP2 = regionLoc2.clone();
				p.sendMessage(ChatColor.BLUE + "Region selected set to region type of spawn.");
				config.set("parkourP1", getStringofLocation(parkourP1));
				config.set("parkourP2", getStringofLocation(parkourP2));
				saveConfig();
				regionLoc1 = null;
				regionLoc2 = null;
				return true;
			}
		}
		return false;
	}

	public void addDiscInfo() {
		discnames.put("13", 178);
		discnames.put("cat", 185);
		discnames.put("blocks", 345);
		discnames.put("chirp", 185);
		discnames.put("far", 174);
		discnames.put("mall", 197);
		discnames.put("mellohi", 96);
		discnames.put("stal", 150);
		discnames.put("strad", 188);
		discnames.put("ward", 251);
		discnames.put("11", 71);
		discnames.put("wait", 238);
	}
		
	public void damageNonCharacter(LivingEntity e, double ammount, Player p) {
		if(e instanceof Monster) {
			if(p != null) {
				e.damage(ammount, p);
			}
			else {
				e.damage(ammount);
			}
		}
		else {
			if(p != null) {
				e.damage(ammount, p);
			}
			else {
				e.damage(ammount);
			}
		}
	}
	
	public void damagePlayerReason(Player player, double ammount, String reason) {
			Player p = player;
			double damage = runDamage(p, reason, ammount, null);
			if(p.getHealth()-damage<=0) {
				p.damage(99999);
			}
			else {
				p.damage(damage);
			}
	}
	
	public void damagePlayerReasonPlayer(Player player, double ammount, String reason, Player attacker) {
		Player p = player;
		double damage = runDamage(p, reason, ammount, null);
		if(p.getHealth()-damage<=0) {
			p.damage(99999, attacker);
		}
		else {
			p.damage(damage, attacker);
		}
	
	}

	public double runDamage(Player p, String type, double ammount, DamageCause dc) {
		if(inSpawnRegion(p.getLocation())) {
			return 0;
		}
		if(!notnpc(p)) {
			return ammount;
		}
		double initialDamage = ammount;
		if(!type.equals("deal")) {
		double health = p.getHealth();
		
		//Remove Damage Based On Armor / Abilities
		if(!type.equals("final")) {
			initialDamage =  damageReducer.ReducedDamageReturn(p, ammount, null);
		}
		if(shopGUIS.enabled.containsKey(p.getName())) {
			List<Integer> abilities = shopGUIS.enabled.get(p.getName());
			if(abilities.contains(35)) {
				if(p.getLevel() >= 1) {
				doCrystallized(p);
				initialDamage = initialDamage / 3.0;
				}
			}
			if(abilities.contains(152)) {
				if(p.getHealth() < 6) {
					initialDamage = initialDamage / 3.0;
				}
			}
			if(abilities.contains(156)) {
				if(p.getHealth() < 6) {
					initialDamage = initialDamage / 10.0;
				}
			}
		}
		
		//Remove Damage Based On Attributes
		if(shopGUIS.enabled.get(p.getName()).contains(177)) {
		if(resisPower.containsKey(p.getName())) {
		initialDamage = initialDamage - resisPower.get(p.getName());
		}
		}
		
		//Remove Damage Based On Server Settings
		}
		return initialDamage;
	}

    public void doCrystallized(Player p) {
    	p.setLevel(p.getLevel()-1);
    	p.getWorld().playSound(p.getLocation(), Sound.BLOCK_GLASS_BREAK, 1, (float) 1.7);
    	p.getWorld().spawnParticle(Particle.END_ROD, p.getLocation().add(0, 1, 0), 10, 0.4, 1, 0.4, 0.001);
    	p.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, p.getLocation().add(0, 1, 0), 10, 0.4, 1, 0.4, 0.001);
    }
	
	///////////////////////////////////////////////////
	
	//Nametag Hiding
	
	public void doScoreboardThing() {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard scoreboard = null;
		if(Bukkit.getScoreboardManager().getMainScoreboard() == null) {
			scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
		}
		else {
			scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
			for(Objective o : scoreboard.getObjectives()) {
				console.sendMessage("" + o.getName());
			}
		}
		boolean hideFound = false;
		for(Team t : scoreboard.getTeams()) {
			if(t.getName().equals("Hide")) {
				hideFound = true;
			}
		}
		Team team = null;
		Team team2 = null;
		if(hideFound == false) {
	    team = scoreboard.registerNewTeam("Hide");
	    if(config.getBoolean("Force Hiding Nametags ")) {
	    	team.setOption(Option.NAME_TAG_VISIBILITY, OptionStatus.NEVER);
	    }
	    else {
	    	team.setOption(Option.NAME_TAG_VISIBILITY, OptionStatus.FOR_OWN_TEAM);
	    }
	    
	    team2 = scoreboard.registerNewTeam("AHide");
	    team2.setOption(Option.NAME_TAG_VISIBILITY, OptionStatus.NEVER);
		}
		else {
			team = scoreboard.getTeam("Hide");
			team2 = scoreboard.getTeam("AHide");
		}
		for(Player p : Bukkit.getOnlinePlayers()){
			if(worlds.contains(p.getWorld().getName())) {
				 if(nametagE) {
			if(p.isOp() || p.hasPermission("survivalmain.seenametags")) {
				team2.addEntry(p.getName());
				p.setScoreboard(scoreboard);
			}
			else {
			team.addEntry(p.getName());
		    p.setScoreboard(scoreboard);
			}
				 }
				 else if(npcE) {
					 team2.addEntry(p.getName().substring(0, p.getName().length()-1) + "~");
					 p.setScoreboard(scoreboard);
				 }
			}
		}
		hide = scoreboard;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		if(worlds.contains(e.getPlayer().getWorld().getName())) {
		Scoreboard scoreboard = hide;
		 
		Player p = e.getPlayer();
		if(nametagE) {
		if(p.isOp() || p.hasPermission("survivalmain.seenametags")) {
			hide.getTeam("AHide").addEntry(p.getName());
			p.setScoreboard(scoreboard);
		}
		else {
			hide.getTeam("Hide").addEntry(p.getName());
			p.setScoreboard(scoreboard);
		}
		}
		else if(npcE) {
			hide.getTeam("AHide").addEntry(p.getName().substring(0, p.getName().length()-1) + "~");
			p.setScoreboard(scoreboard);
		}
		}
	}
	
	public void hideEntity(LivingEntity p) {
		Scoreboard scoreboard = hide;
		 
		hide.getTeam("AHide").addEntry(p.getName());
		((Player) p).setScoreboard(scoreboard);
	}
	
	///////////////////////////////////////////////////
	
	//Death
	
	//Removing Messages
	
	public boolean isNotWorld(Entity e) {
		if(worlds.contains(e.getWorld().getName())) {
			return false;
		}
		return true;
	}
	
	@EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
		if(isNotWorld(e.getEntity())) {
			return;
		}
		if(worlds.contains(e.getEntity().getWorld().getName())) {
			if(inSpawnRegion(e.getEntity().getLocation())) {
				return;
			}
		if(bloodDropsE) {
		ItemStack m = new ItemStack(Material.BEEF);
		ItemStack m1 = new ItemStack(Material.MUTTON);
		ItemStack m2 = new ItemStack(Material.BONE);
		ItemStack m3 = new ItemStack(Material.BONE_MEAL);
		ItemStack m4 = new ItemStack(Material.RED_DYE);
		ItemStack m5 = new ItemStack(Material.WHITE_DYE);
		ItemStack m6 = new ItemStack(Material.FERMENTED_SPIDER_EYE);
		ItemMeta itemmeta = m.getItemMeta();
		ItemMeta itemmeta1 = m1.getItemMeta();
		ItemMeta itemmeta2 = m2.getItemMeta();
		ItemMeta itemmeta3 = m3.getItemMeta();
		ItemMeta itemmeta4 = m4.getItemMeta();
		ItemMeta itemmeta5 = m5.getItemMeta();
		ItemMeta itemmeta6 = m6.getItemMeta();
		itemmeta.setDisplayName("§fHuman Meat");
		itemmeta1.setDisplayName("§fHuman Meat");
		itemmeta3.setDisplayName("§fBone Marrow");
		itemmeta4.setDisplayName("§fBlood");
		itemmeta5.setDisplayName("§fBone Fragment");
		itemmeta6.setDisplayName("§fEyeball");
		m.setAmount(randor.nextInt(3)+1);
		m1.setAmount(randor.nextInt(3)+1);
		m2.setAmount(randor.nextInt(3)+1);
		m3.setAmount(randor.nextInt(3)+1);
		m4.setAmount(randor.nextInt(3)+1);
		m5.setAmount(randor.nextInt(3)+1);
		m6.setAmount(2);
		m.setItemMeta(itemmeta);
		m1.setItemMeta(itemmeta1);
		m2.setItemMeta(itemmeta2);
		m3.setItemMeta(itemmeta3);
		m4.setItemMeta(itemmeta4);
		m5.setItemMeta(itemmeta5);
		m6.setItemMeta(itemmeta6);
		e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), m);
		e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), m1);
		e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), m2);
		e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), m3);
		e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), m4);
		e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), m5);
		e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), m6);
		}
		Player p = e.getEntity();
		if(bloodE) {
		p.getWorld().playSound(p.getLocation(), Sound.BLOCK_LAVA_POP, 1, 2);
		for(int space = 0; space < 25; space++) {
			p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().getX()+(coinFlip()*(randor.nextInt(300)/1000.0)), (p.getLocation().getY() + 1)+(coinFlip()*(randor.nextInt(1000)/1000.0)), p.getLocation().getZ()+(coinFlip()*(randor.nextInt(300)/1000.0)), 1, Material.NETHER_WART_BLOCK.createBlockData());
		}
		}
		if(deathMessageE) {
        e.setDeathMessage("");
		}
		}
    }
	
	//Blood Splatters
	
	@EventHandler
	public void onPlayerDamageFromEntity(EntityDamageByEntityEvent e) {
		if(isNotWorld(e.getEntity())) {
			return;
		}
		if(worlds.contains(e.getEntity().getWorld().getName())) {
			if(inSpawnRegion(e.getEntity().getLocation()) || e.isCancelled()) {
				return;
			}
			if(bloodE) {
		if(notnpc(e.getEntity())) {
			if(e.getDamager().hasMetadata("player") || e.getEntity().isInvulnerable() || e.isCancelled()) {
				return;
			}
			Player p = (Player) e.getEntity();
			if(limboE) {
			if(limbo.contains(p.getName())) {
				return;
			}
			}
			if(p.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
				return;
			}
			if(randor.nextBoolean()) {
				p.getWorld().playSound(p.getLocation(), Sound.BLOCK_LAVA_POP, 1, 2);
				for(int space = 0; space < 25; space++) {
					p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation().getX()+(coinFlip()*(randor.nextInt(300)/1000.0)), (p.getLocation().getY() + 1)+(coinFlip()*(randor.nextInt(1000)/1000.0)), p.getLocation().getZ()+(coinFlip()*(randor.nextInt(300)/1000.0)), 1, Material.NETHER_WART_BLOCK.createBlockData());
				}
				if(bloodDropsE) {
			if(isNotSolid(p.getLocation().getBlock().getLocation(), true)&&(!(isNotSolid(p.getLocation().getBlock().getLocation().subtract(0, 1, 0), false)))) {
				Block b = p.getLocation().getBlock();
				b.setType(Material.REDSTONE_WIRE);
				b.setMetadata("blood", new FixedMetadataValue(this, 0));
			}
				}
			}
		}
			}
		}
	}
	
	public boolean isNotSolid(Location l, boolean justair) {
		Block b = l.getBlock();
		if(b != null) {
			Material m = b.getType();
			if(justair) {
				if(isAir(m)) {
					return true;
				}
			}
			else if(isAir(m) || m == Material.WATER || m == Material.LAVA){
				return true;
			}
		}
		return false;
	}
	
	@EventHandler
	public void onBloodBreak(BlockBreakEvent e) {
		if(worlds.contains(e.getBlock().getWorld().getName())) {
			if(inSpawnRegion(e.getBlock().getLocation())) {
				return;
			}
			if(limboE) {
		if(limbo.contains(e.getPlayer().getName())) {
			return;
		}
			}
		Block b = e.getBlock();
		Block b2 = e.getBlock().getRelative(BlockFace.UP);
		if(b.hasMetadata("blood")) {
			b.removeMetadata("blood", this);
			if(b.getType() == Material.REDSTONE_WIRE) {
			e.setCancelled(true);
			b.setType(Material.AIR);
			doBloodDestroyParticles(b.getLocation());
			}
		}
		else if(b2.hasMetadata("blood")) {
			b2.removeMetadata("blood", this);
			if(b2.getType() == Material.REDSTONE_WIRE) {
			b2.setType(Material.AIR);
			doBloodDestroyParticles(b2.getLocation());
			}
		}
		}
	}
	
	@EventHandler
	public void entityExplodeBlood(EntityExplodeEvent e) {
		if(bloodE) {
			if(config.getBoolean("Enable Blood Check Explosions ")) {
				for(Block b : e.blockList()) {
					Block b2 = b.getRelative(BlockFace.UP);
					if(b.hasMetadata("blood")) {
						b.removeMetadata("blood", this);
						if(b.getType() == Material.REDSTONE_WIRE) {
						b.setType(Material.AIR);
						doBloodDestroyParticles(b.getLocation());
						}
					}
					else if(b2.hasMetadata("blood")) {
						b2.removeMetadata("blood", this);
						if(b2.getType() == Material.REDSTONE_WIRE) {
						b2.setType(Material.AIR);
						doBloodDestroyParticles(b2.getLocation());
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void entityExplodeBlood2(BlockExplodeEvent e) {
		if(bloodE) {
			if(config.getBoolean("Enable Blood Check Explosions ")) {
				for(Block b : e.blockList()) {
					Block b2 = b.getRelative(BlockFace.UP);
					if(b.hasMetadata("blood")) {
						b.removeMetadata("blood", this);
						if(b.getType() == Material.REDSTONE_WIRE) {
						b.setType(Material.AIR);
						doBloodDestroyParticles(b.getLocation());
						}
					}
					else if(b2.hasMetadata("blood")) {
						b2.removeMetadata("blood", this);
						if(b2.getType() == Material.REDSTONE_WIRE) {
						b2.setType(Material.AIR);
						doBloodDestroyParticles(b2.getLocation());
						}
					}
				}
			}
		}
	}
	
	@EventHandler
    public void onBloodFlow(BlockFromToEvent e) {
		Block b = e.getToBlock();
		if(b.hasMetadata("blood")) {
			b.removeMetadata("blood", this);
			if(b.getType() == Material.REDSTONE_WIRE) {
			e.setCancelled(true);
			b.setType(Material.AIR);
			doBloodDestroyParticles(b.getLocation());
			}
		}
    }
	
	public void doBloodDestroyParticles(Location l) {
		Block b = l.getBlock();
		for(int space = 0; space < 10; space++) {
			l.getWorld().spawnParticle(Particle.BLOCK_CRACK, (b.getLocation().getX()+0.5)+(coinFlip()*(randor.nextInt(200)/1000.0)), b.getLocation().getY(), (b.getLocation().getZ()+0.5)+(coinFlip()*(randor.nextInt(200)/1000.0)), 1, Material.NETHER_WART_BLOCK.createBlockData());
		}
	}
	
	///////////////////////////////////////////////////
	
	//Crawling
	
	ArrayList<Player> doubletap = new ArrayList<Player>();
	ArrayList<Player> crawlers = new ArrayList<Player>();
	
	public void crawlLoop() {
		ArrayList<Player> crawlersCopy = new ArrayList<Player>(crawlers);
		for(Player p : crawlersCopy) {
			if(hasBlockOnTop(p) || (!hasBlockOnBottom(p))) {
				p.setGliding(false);
				p.setWalkSpeed((float) 0.2);
				p.setFlySpeed((float) 0.1);
				if(p.hasPotionEffect(PotionEffectType.JUMP)) {
					p.removePotionEffect(PotionEffectType.JUMP);
				}
			}
			else {
			p.setGliding(true);
			if(!p.hasPotionEffect(PotionEffectType.JUMP)) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999, -1, false, false));
			}
			if(p.isSprinting()) {
				p.setWalkSpeed((float) 0.2);
				p.setVelocity(p.getLocation().getDirection().normalize().multiply(.05));
			}
			else {
				p.setWalkSpeed(0);
				p.setFlySpeed(0);
				p.setVelocity(new Vector(0, 0, 0));
			}
			if(p.getLocation().getPitch()>5) {
				Location ploc = p.getLocation();
				ploc.setPitch((float) 5);
				ploc.setYaw(p.getLocation().getYaw());
				p.teleport(ploc);
			}
			else if(p.getLocation().getPitch()<-25) {
				Location ploc = p.getLocation();
				ploc.setPitch((float) -25);
				ploc.setYaw(p.getLocation().getYaw());
				p.teleport(ploc);
			}
			if(p.isSprinting()) {
			canPlaceBarrier(p);
			}
			}
		}
	}
	
	public void canPlaceBarrier(Player p) {
		BlockFace bf = p.getFacing();
		Block b = p.getLocation().getBlock().getRelative(bf);
		if(b.isPassable()||(isAir(b.getType()))) {
			Block b2 = b.getLocation().add(0, 1, 0).getBlock();
			if((!b2.isPassable()) && (!(isAir(b2.getType())))) {
				p.setGliding(false);
				p.setWalkSpeed((float) 0.2);
				p.setFlySpeed((float) 0.1);
				if(p.hasPotionEffect(PotionEffectType.JUMP)) {
					p.removePotionEffect(PotionEffectType.JUMP);
				}
				p.setInvulnerable(true);
				Location l = p.getLocation().add(0, 1, 0).getBlock().getLocation();
				l.getBlock().setType(Material.BARRIER);
				Location l2 = new Location(l.getWorld(), l.getX(), l.getY(), l.getZ());
				Bukkit.getScheduler().runTaskLater(this, () ->  l2.clone().getBlock().setType(Material.AIR), (long) 5);
				Bukkit.getScheduler().runTaskLater(this, () ->  p.setInvulnerable(false), (long) 5);
			}
		}
	}
	
	public boolean hasBlockOnTop(Player p) {
		Location l = p.getLocation().add(0, 1, 0);
		if((!l.getBlock().isPassable()) && (!(isAir(l.getBlock().getType())))) {
			return true;
		}
		return false;
	}
	
	public boolean hasBlockOnBottom(Player p) {
		Location l = p.getLocation().subtract(0, 1, 0);
		if((!l.getBlock().isPassable()) && (!(isAir(l.getBlock().getType())))) {
			return true;
		}
		return false;
	}
	
	@EventHandler
	public void onSneak(PlayerToggleSneakEvent e) {
		Player p = e.getPlayer();
		if(worlds.contains(p.getWorld().getName())) {
			if(crawlingE) {
		if(!p.isSneaking()) {
			if(!p.isSneaking() && crawlers.contains(p)){
				crawlers.remove(p); 
				p.setWalkSpeed((float) 0.2);
				p.setFlySpeed((float) 0.1);
				if(p.hasPotionEffect(PotionEffectType.JUMP)) {
					p.removePotionEffect(PotionEffectType.JUMP);
				}
			}
			else {
			if(doubletap.contains(p)) {
				if(crawlers.contains(p)) {
					crawlers.remove(p);
				}
				crawlers.add(p);
				doubletap.remove(p);
			}
			else {
				doubletap.add(p);
				Bukkit.getScheduler().runTaskLater(this, () ->  doubletap.remove(p), (long) 10);
			}
			}
		}
			}
		}
	}
	
	public boolean isCrawling(Player p) {
		if(crawlers.contains(p)) {
			return true;
		}
		return false;
	}
	
	///////////////////////////////////////////////////
	
	//Stealth
	
	private static boolean getLookingAt(LivingEntity entitylooking, LivingEntity entity2) {
		Location eye = entitylooking.getEyeLocation();
		Vector toEntity = ((LivingEntity) entity2).getEyeLocation().toVector().subtract(eye.toVector());
		double dot = toEntity.normalize().dot(eye.getDirection());

		return dot > 0.70D;
	}
	
	public boolean exists(Entity e) {
		if(e == null) {
			return false;
		}
		if(e.isDead()) {
			return false;
		}
		return true;
	}
	
	@EventHandler
	public void onTargeted(EntityTargetEvent e) {
		if(!exists(e.getTarget())) {
			return;
		}
		if(isNotWorld(e.getEntity())) {
			return;
		}
		if(worlds.contains(e.getEntity().getWorld().getName())) {
			if(inSpawnRegion(e.getEntity().getLocation())) {
				return;
			}
			if(detectionE) {
		if(e.getTarget() instanceof Player) {
			if(e.getEntity() instanceof Monster) {
				if(!isFound(e.getEntity(), e.getTarget())) {
					e.setCancelled(true);
				}
				else {
					targeted((LivingEntity) e.getEntity(), (LivingEntity) e.getTarget());
				}
			}
		}
			}
		}
	}
	
	public boolean isFound(Entity monster, Entity player) {
		if(limbo.contains(((Player) player).getName()) || monster.hasMetadata("player") || monster.hasMetadata("darkness")) {
			return false;
		}
		if(((LivingEntity) monster).hasPotionEffect(PotionEffectType.BLINDNESS)) {
			return false;
		}
		if(((LivingEntity) player).hasPotionEffect(PotionEffectType.INVISIBILITY)) {
			return false;
		}
		boolean isLookingAt = getLookingAt((LivingEntity) monster, (LivingEntity) player);
		Player p = ((Player) player);
		int llevel = p.getLocation().getBlock().getLightLevel();
		if((isLookingAt && llevel >= 10 && p.getLocation().getBlock().getLightFromSky()<=8) || monster.hasMetadata("The Darkness")) {
			return true;
		}
		int distance = (int) (monster.getLocation().distance(player.getLocation())/3.0);
		int foundAm = 0;
		if(isCrawling(p)) {
			foundAm+=10;
		}
		else {
		if(p.isSneaking()) {
			foundAm+=5;
		}
		if(p.isSprinting()) {
			foundAm-=12;
		}
		}
		if(isLookingAt) {
			int lookingat = 20;
			if(distance <= 0) {
				lookingat = 20;
			}
			else {
				lookingat = (20 / (distance));
			}
			foundAm-=lookingat;
		}
		else {
			foundAm+=10;
		}
		if(getAboveGround(p.getLocation())) {
			if(p.getWorld().isThundering()) {
				foundAm += 5;
			}
		}
		if(((Monster) monster).getLastDamageCause()!=null) {
			if(((Monster) monster).getLastDamageCause().getCause() == DamageCause.ENTITY_ATTACK) {
				foundAm-=9;
			}
		}
		int lightlevel = (llevel*-1)+10;
		foundAm+=(lightlevel);
		if(foundAm>5) {
			return false;
		}
		else {
			return true;
		}
	}
	
	///////////////////////////////////////////////////
	
	//Chat Physics
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		if(worlds.contains(e.getPlayer().getWorld().getName())) {
			if(chatE) {
		String name = e.getPlayer().getName();
		if(namesE) {
		if(usernames.containsKey(name)) {
			name = usernames.get(name);
		}
		}
		String message = "[" + name + "] : " + e.getMessage();
		e.setCancelled(true);
		console.sendMessage(message);
		Player p = e.getPlayer();
		if(limboE) {
		if(limbo.contains(p.getName())) {
			return;
		}
		}
		p.sendMessage(message);
		List<Player> recieving = new ArrayList<Player>();
		for(Entity entity : p.getNearbyEntities(70, 70, 70)) {
			if(entity instanceof Player) {
				recieving.add((Player) entity);
			}
		}
		for(Player p2 : recieving) {
			if(limbo.contains(p2.getName())) {
				
			}
			else {
			int noise = getNoise(p2, p);
			if(noise < 10) {
			p2.sendMessage(addNoise(message, noise, (int) p2.getLocation().distance(p.getLocation())));
			}
			}
		}
			}
			else if(namesE) {
				String name = e.getPlayer().getName();
				if(limboE) {
					if(limbo.contains(name)) {
						e.setCancelled(true);
						return;
					}
				}
				if(usernames.containsKey(name)) {
					name = usernames.get(name);
				}
				String message = "[" + name + "] : " + e.getMessage();
				e.setFormat(message);
			}
			else {
				String name = e.getPlayer().getName();
				if(limboE) {
					if(limbo.contains(name)) {
						e.setCancelled(true);
						return;
					}
				}
			}
		}
	}
	
	public int getNoise(Player reciever, Player sender) {
		Location rl = reciever.getLocation();
		Location sl = sender.getLocation();
		double noise = 0;
		//distance
		double distance = sl.distance(rl);
		noise += distance / 11;
		//weather and outside
		if(sender.getWorld().isThundering()) {
			if(sl.getBlock().getLightFromSky()>3||rl.getBlock().getLightFromSky()>3) {
				noise += .5;
			}
		}
		boolean insideCave = false;
		//in a cave
		if(rl.getY()<50 || sl.getY() < 50) {
			if(sl.getBlock().getLightFromSky()<=0||rl.getBlock().getLightFromSky()<=0) {
		if(rl.clone().subtract(0, 1, 0).getBlock().getType().name().toLowerCase().contains("stone")||rl.clone().subtract(0, 1, 0).getBlock().getType().name().toLowerCase().contains("dirt")||
				sl.clone().subtract(0, 1, 0).getBlock().getType().name().toLowerCase().contains("stone")||sl.clone().subtract(0, 1, 0).getBlock().getType().name().toLowerCase().contains("dirt")) {
			noise -= 1;
			insideCave = true;
		}
			}
		}
		//inside building
		if(insideCave == false) {
			if(sl.getBlock().getLightFromSky()<=0||rl.getBlock().getLightFromSky()<=0) {
				noise -= .8;
			}
		}
		//under water or lava
		if(rl.clone().add(0, 1, 0).getBlock().getType()==Material.WATER||rl.clone().add(0, 1, 0).getBlock().getType()==Material.LAVA||
				sl.clone().add(0, 1, 0).getBlock().getType()==Material.WATER||sl.clone().add(0, 1, 0).getBlock().getType()==Material.LAVA) {
			noise += .5;
		}
		//low health
		if(reciever.getHealth()<10||sender.getHealth()<10) {
			if(reciever.getHealth() < 10) {
				noise += reciever.getHealth()/10.0;
			}
			if(sender.getHealth() < 10) {
				noise += sender.getHealth()/10.0;
			}
		}
		//blocks between
		List<Block> blocks = new ArrayList<Block>(getBlocks(rl, sl, (int) distance));
		noise += getNoiseCancel(blocks);
		
		return (int) noise;
	}
	
	public double getNoiseCancel(List<Block> blocks) {
		double noise = 0;
		for(Block b : blocks) {
			Material m = b.getType();
			String name = m.name().toLowerCase();
			if(name.contains("wool")) {
				noise += 0.8;
			}
			else if(name.contains("obsidian")) {
				noise += 20;
			}
			else if(name.contains("leave")) {
				noise += 0.02;
			}
			else if(name.contains("stone")||name.contains("dirt")) {
				noise += 0.2;
			}
			else if(name.contains("wood")||name.contains("log")) {
				noise += 0.14;
			}
			else {
				noise += 0.1;
			}
		}
		return noise;
	}
	
	public List<Block> getBlocks(Location l1, Location l2, int distance){
		List<Block> blocks = new ArrayList<Block>();
		Vector v = l1.clone().add(0, 1, 0).toVector().subtract(l2.clone().add(0, 1, 0).toVector()).normalize();
		final BlockIterator bit = new BlockIterator(l2.getWorld(), l2.clone().add(0, 1, 0).toVector(), v, 0, (int) distance+1);

		while (bit.hasNext()) {
			Block b = bit.next();
			if(b != null) {
				if(!b.isPassable() && (!(isAir(b.getType())))) {
					blocks.add(b);
				}
			}
		}
		return blocks;
	}
	
	public static List<Block> getBlocksInLine(Location loc1, Location loc2) {
        List<Block> blocks = new ArrayList<>();
        int distance = (int) Math.ceil(loc1.distance(loc2));
        Vector direction = loc2.toVector().subtract(loc1.toVector());
        direction.setX(Math.ceil((direction.getX() / distance) * 100D) / 100D).setY(direction.getY() / distance).setZ(Math.ceil((direction.getZ() / distance) * 100D) / 100D);
        Vector vec1 = loc1.toVector();
        for (int x = 0; x <= distance; x++) {
            Block b = vec1.add(direction).toLocation(loc1.getWorld()).getBlock();
            blocks.add(b);
            if (b.equals(loc2.getBlock())) {
                break;
            }
        }
        return blocks;
    }
	
	public String addNoise(String message, int noise, int distance) {
		int indvnoise = noise;
		int type = 0;
		String newmessage = "";
		for(int count = 0; count < message.length(); count++) {
			boolean changed = false;
			char c = message.charAt(count);
			if(c == '*') {
				// *shouts* *whispers* *says*
				if(count + 6 <= message.length()) {
					if(message.substring(count, count+6).equals("*says*")) {
						indvnoise = noise;
						count += 5;
						changed = true;
						type = 0;
					}
				}
				if(count + 8 <= message.length()) {
					if(message.substring(count, count+8).equals("*shouts*")) {
						indvnoise = noise - 3;
						if(indvnoise < 0) {
							indvnoise = 0;
						}
						count += 7;
						changed = true;
						type = 1;
					}
				}
				if(count + 10 <= message.length()) {
					if(message.substring(count, count+10).equals("*whispers*")) {
						indvnoise = noise + 1;
						count += 9;
						changed = true;
						type = 2;
					}
				}
			}
			if(type == 2) {
				if(changed==false && distance <= 3) {
					if(randor.nextInt((indvnoise/2)+1)==0) {
						newmessage += ChatColor.GRAY + "" + ChatColor.ITALIC + "" + c + "" + ChatColor.RESET + "";
					}
					else {
						newmessage += " ";
					}
				}
			}
			else if(type == 1) {
				if(changed==false) {
					if(randor.nextInt((indvnoise/2)+1)==0) {
						newmessage += ChatColor.WHITE + "" + ChatColor.BOLD + "" + c + "" + ChatColor.RESET + "";
					}
					else if(randor.nextInt((indvnoise/2)+1)==0) {
						newmessage += ChatColor.GRAY + "" + ChatColor.BOLD + "" + c + "" + ChatColor.RESET + "";
					}
					else if(randor.nextInt((indvnoise/2)+1)==0||randor.nextInt((indvnoise)+1)==0) {
						newmessage += ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "" + c + "" + ChatColor.RESET + "";
					}
					else if(randor.nextInt((indvnoise/2)+1)==0||randor.nextInt((indvnoise)+1)==0||randor.nextInt((indvnoise)+1)==0) {
						newmessage += ChatColor.BLACK + "" + ChatColor.BOLD + "" + c + "" + ChatColor.RESET + "";
					}
					else {
						newmessage += " ";
					}
					}
			}
			else {
			if(changed==false) {
			if(randor.nextInt((indvnoise/2)+1)==0) {
				newmessage += ChatColor.WHITE + "" + c + "" + ChatColor.RESET + "";
			}
			else if(randor.nextInt((indvnoise/2)+1)==0) {
				newmessage += ChatColor.GRAY + "" + c + "" + ChatColor.RESET + "";
			}
			else if(randor.nextInt((indvnoise/2)+1)==0||randor.nextInt((indvnoise)+1)==0) {
				newmessage += ChatColor.DARK_GRAY + "" + c + "" + ChatColor.RESET + "";
			}
			else if(randor.nextInt((indvnoise/2)+1)==0||randor.nextInt((indvnoise)+1)==0||randor.nextInt((indvnoise)+1)==0) {
				newmessage += ChatColor.BLACK + "" + c + "" + ChatColor.RESET + "";
			}
			else {
				newmessage += " ";
			}
			}
			}
		}
		return newmessage;
	}
	
	///////////////////////////////////////////////////
	
	//Thirst
	
	@EventHandler
	public void onPlayerQuitThirst(PlayerQuitEvent e) {
		if(thirstE) {
			Player p = e.getPlayer();
			if(exists(p)) {
				if(thirst.containsKey(p)) {
				int thirstA = thirst.get(p);
				thirstN.put(p.getName(), thirstA);
				}
			}
		}
	}
	
	@EventHandler
	public void onPlayerJoinThirst(PlayerJoinEvent e) {
		if(thirstE) {
			Player p = e.getPlayer();
			if(exists(p)) {
				if(thirstN.containsKey(p.getName())) {
				int thirstA = thirstN.get(p.getName());
				thirst.put(p, thirstA);
				}
			}
		}
	}
	
	public void sendThirstMessage(int thirstA, Player p, boolean adding) {
		if(thirstA <= 0) {
			thirstA = 0;
		}
		if(thirstA >= 100) {
			thirstA = 100;
		}
		thirst.put(p, thirstA);
		if(adding || thirstA % 5 == 0) {
		p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.BOLD + "" + ChatColor.BLUE + "-(" + thirstA + ")-"));
		}
	}
	
	public void decreaseThirst() {
		HashMap<Player, Integer> players = new HashMap<Player, Integer>(thirst);
		for(Player p : players.keySet()) {
			if((!worlds.contains(p.getWorld().getName())) ||inSpawnRegion(p.getLocation()) || (p.getGameMode()==GameMode.CREATIVE||p.getGameMode()==GameMode.SPECTATOR)) {
				
			}
			else if(limbo.contains(p.getName())) {
				
			}
			else {
			if(p != null) {
				if(p.isOnline()) {
					int thirstA = players.get(p);
					if(p.getLocation().getBlock().getBiome() == Biome.NETHER) {
						thirstA -= 2;
					}
					thirstA -= 1;
					sendThirstMessage(thirstA, p, false);
				}
			}
			}
		}
	}
	
	public void thirstEffects() {
		HashMap<Player, Integer> players = new HashMap<Player, Integer>(thirst);
		for(Player p : players.keySet()) {
			if(worlds.contains(p.getWorld().getName())) {
			if(inSpawnRegion(p.getLocation()) || (p.getGameMode()==GameMode.CREATIVE||p.getGameMode()==GameMode.SPECTATOR)) {

			}
			else if(limbo.contains(p.getName())) {

			}
			else {
			if(p != null) {
				if(p.isOnline()) {
					int thirstA = players.get(p);
					if(thirstA < 25) {
						addPotionEffectBetter(p, PotionEffectType.SLOW, 40, 0, false, false, false);
					}
					if(thirstA < 15) {
						addPotionEffectBetter(p, PotionEffectType.CONFUSION, 80, 15, false, false, false);
					}
					if(thirstA < 5) {
						addPotionEffectBetter(p, PotionEffectType.SLOW_DIGGING, 40, 0, false, false, false);
						if(randor.nextInt(3)==1) {
							p.damage(1);
						}
					}
				}
			}
			}
			}
		}
	}
	
	public void heartBeatSound() {
		HashMap<Player, Integer> players = new HashMap<Player, Integer>(thirst);
		for(Player p : players.keySet()) {
			if((p.getGameMode()==GameMode.CREATIVE||p.getGameMode()==GameMode.SPECTATOR)) {
				
			}
		else {
			if(worlds.contains(p.getWorld().getName())) {
			if(p != null) {
				if(p.isOnline()) {
					int thirstA = players.get(p);
					if(thirstA < 25) {
					if(thirstA >= 15) {
						p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASEDRUM, (float) .04, 2);
						Bukkit.getScheduler().runTaskLater(this, () -> p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASEDRUM, (float) .01, 2), 4);
					}
					else if(thirstA >= 5) {
						p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASEDRUM, (float) .04, 2);
						Bukkit.getScheduler().runTaskLater(this, () -> p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASEDRUM, (float) .04, 2), 4);
					}
					else {
						addPotionEffectBetter(p, PotionEffectType.BLINDNESS, randor.nextInt(9)+1, 0, false, false, false);
						p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASEDRUM, (float) .04, 2);
						Bukkit.getScheduler().runTaskLater(this, () -> p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASEDRUM, (float) .08, 2), 4);
						Bukkit.getScheduler().runTaskLater(this, () -> addPotionEffectBetter(p, PotionEffectType.BLINDNESS, randor.nextInt(9)+1, 0, false, false, false), 4);
						}
					}
				}
			}
			}
		}
		}
	}
	
	@EventHandler
	public void playerAddOnJoin(PlayerJoinEvent e) {
		if(worlds.contains(e.getPlayer().getWorld().getName())) {
		if(thirstE) {
		if(!thirst.containsKey(e.getPlayer())) {
			thirst.put(e.getPlayer(), 100);
		}
		}
		}
	}
	
	@EventHandler
	public void onPlayerDrink(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(worlds.contains(p.getWorld().getName()) && thirstE) {
		if(limboE) {
		if(limbo.contains(p.getName())) {
			return;
		}
		}
		if(p.isSneaking()) {
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
			if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(e.getClickedBlock().getRelative(e.getBlockFace()).getType() == Material.WATER) {
					p.getWorld().playSound(p.getLocation(), Sound.ENTITY_GENERIC_DRINK, 1, (float) 1.3);
					int thirstA = thirst.get(p)+5;
					sendThirstMessage(thirstA, p, true);
				}
			}
			else {
				Vector v = p.getLocation().getDirection().normalize();
				final BlockIterator bit = new BlockIterator(p.getWorld(), p.getLocation().add(0, 1, 0).toVector(), v, 0, (int) 2);

				while (bit.hasNext()) {
					Block b = bit.next();
					if(b != null) {
						if(!b.isPassable() && (!(isAir(b.getType())))) {
							break;
						}
						else if(b.getType() == Material.WATER) {
							p.getWorld().playSound(p.getLocation(), Sound.ENTITY_GENERIC_DRINK, 1, (float) 1.3);
							int thirstA = thirst.get(p)+5;
							sendThirstMessage(thirstA, p, true);
							break;
						}
						else {
							
						}
					}
				}
			}
		}
		}
		}
	}
	
	@EventHandler
    public void onPlayerDeathDrink(PlayerDeathEvent e){
		Player p = e.getEntity();
		if(worlds.contains(p.getWorld().getName())) {
			if(thirstE) {
		if(thirst.containsKey(p)) {
			thirst.put(p, 100);
		}
			}
		}
    }

	@EventHandler
	public void onPlayerDrink(PlayerItemConsumeEvent e) {
		ItemStack i = e.getItem();
		Player p = e.getPlayer();
		if(worlds.contains(p.getWorld().getName())) {
		if(limboE) {
		if(limbo.contains(p.getName())) {
			return;
		}
		}
		if(thirst.containsKey(p)) {
			int thirstA = thirst.get(p);
			Material m = i.getType();
			if(m == Material.POTION || m == Material.MELON_SLICE || m == Material.MILK_BUCKET || m == Material.APPLE || m == Material.MUSHROOM_STEW 
					|| m == Material.RABBIT_STEW || m == Material.CARROT || m == Material.GOLDEN_APPLE || m == Material.ENCHANTED_GOLDEN_APPLE || m == Material.SWEET_BERRIES
					|| m == Material.BEETROOT_SOUP || m == Material.BEETROOT) {
				if(m == Material.POTION) {
					thirstA += 40;
				}
				else if(m == Material.MELON_SLICE || m == Material.APPLE || m == Material.GOLDEN_APPLE) {
					thirstA += 25;
				}
				else if(m == Material.MILK_BUCKET || m == Material.MUSHROOM_STEW || m == Material.BEETROOT_SOUP || m == Material.RABBIT_STEW) {
					thirstA += 20;
				}
				else if(m == Material.CARROT || m == Material.SWEET_BERRIES || m == Material.BEETROOT) {
					thirstA += 10;
				}
				else if(m == Material.ENCHANTED_GOLDEN_APPLE) {
					thirstA += 100;
				}
			}
			sendThirstMessage(thirstA, p, true);
		}
		}
	}
	
	///////////////////////////////////////////////////
	
	//Better Fire Particles on Entities
	
	List<LivingEntity> onFire = new ArrayList<LivingEntity>();

	@EventHandler
	public void onSetOnFire(EntityCombustEvent e) {
		if(worlds.contains(e.getEntity().getWorld().getName()) && fireE) {
		if(e.getEntity() instanceof LivingEntity && (!(e.getEntity().hasMetadata("player")))) {
			if(e.getEntity() instanceof Zombie || e.getEntity() instanceof Skeleton) {
				if(!isNight(e.getEntity().getWorld())) {
					if(e.getEntity().getLocation().getBlock().getLightFromSky()>0) {
						return;
					}
				}
			}
			onFire.add((LivingEntity) e.getEntity());
		}
		}
	}
	
	public boolean isValid(LivingEntity e) {
		if(e == null) {
			return false;
		}
		if(e.isDead()) {
			return false;
		}
		return true;
	}
	
	public void fireLoop() {
		List<LivingEntity> onFireCopy = new ArrayList<LivingEntity>(onFire);
		for(LivingEntity e : onFireCopy) {
			if(isValid(e)) {
				if(e.getFireTicks() > 0) {
					if(e instanceof Blaze || e instanceof Ghast || e instanceof WitherSkeleton) {
						onFire.remove(e);
					}
					else if(e instanceof Enderman || e instanceof Player || e instanceof Zombie || e instanceof Skeleton || e instanceof Illager || e instanceof Creeper || e instanceof Witch) {
						if(randor.nextInt(2)==0) {
						e.getWorld().spawnParticle(Particle.FLAME, e.getLocation().add(0, 1, 0), (randor.nextInt(3)+1), 0.2, 0.5, 0.2, 0.01);
						}
						if(randor.nextInt(3)==0) {
						e.getWorld().spawnParticle(Particle.SMOKE_NORMAL, e.getLocation().add(0, 1, 0), (randor.nextInt(3)+1), 0.2, 0.5, 0.2, 0.01);
						}
						if(randor.nextInt(5)==0) {
							e.getWorld().spawnParticle(Particle.LAVA, e.getLocation(), (randor.nextInt(2)+1), 0.1, 0, 0.1, 0.01);
						}
						if(randor.nextInt(10)==0) {
							e.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, e.getLocation().add(0, 1, 0), (randor.nextInt(2)+1), 0.2, 0.5, 0.2, 0.01);
						}
					}
					else {
						BoundingBox bb = e.getBoundingBox();
						double heightAdd = bb.getHeight() / 2.0;
						double width = (bb.getWidthX() + bb.getWidthZ()) / 2.0;
						if(randor.nextInt(2)==0) {
						e.getWorld().spawnParticle(Particle.FLAME, e.getLocation().add(0, heightAdd, 0), (randor.nextInt(3)+1), width/3.0, heightAdd/2.0, width/3.0, 0.015);
						}
						if(randor.nextInt(3)==0) {
						e.getWorld().spawnParticle(Particle.SMOKE_NORMAL, e.getLocation().add(0, heightAdd, 0), (randor.nextInt(3)+1), width/3.0, heightAdd/2.0, width/3.0, 0.015);
						}
						if(randor.nextInt(5)==0) {
							e.getWorld().spawnParticle(Particle.LAVA, e.getLocation(), (randor.nextInt(2)+1), width/4.0, 0, width/4.0, 0.015);
						}
						if(randor.nextInt(10)==0) {
							e.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, e.getLocation().add(0, heightAdd, 0), (randor.nextInt(2)+1), width/3.0, heightAdd/2.0, width/3.0, 0.015);
						}
					}
				}
				else {
					onFire.remove(e);
				}
			}
			else {
				onFire.remove(e);
			}
		}
	}
	
	///////////////////////////////////////////////////
	boolean nau = false;
	
	@EventHandler
	public void onPetSpawn(CreatureSpawnEvent e) {
		if(nau) {
		if(!e.isCancelled()) {
		if(e.getSpawnReason() == SpawnReason.NATURAL) {
			e.getEntity().setMetadata("natural", new FixedMetadataValue(this, 0));
		}
		}
		}
	}
	
	//Mob Effects (Blood and Better Drops)
	
	@EventHandler
	public void onMobDamageFromEntity(EntityDamageByEntityEvent e) {
		if(isNotWorld(e.getEntity())) {
			return;
		}
		if(worlds.contains(e.getEntity().getWorld().getName()) && bloodE) {
			if(inSpawnRegion(e.getEntity().getLocation()) || e.isCancelled() || e.getEntity().isInvulnerable() || e.getEntity().hasMetadata("darkness")) {
				return;
			}
		if(e.getEntity() instanceof LivingEntity && (!(e.getEntity() instanceof Player || e.getEntity() instanceof Silverfish || e.getEntity() instanceof ArmorStand))) {
			LivingEntity le = (LivingEntity) e.getEntity();
			if(le.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
				return;
			}
			if(randor.nextBoolean()) {
				le.getWorld().playSound(le.getLocation(), Sound.BLOCK_LAVA_POP, 1, 2);
				BoundingBox bb = le.getBoundingBox();
				double heightAdd = bb.getHeight() / 2.0;
				double width = (bb.getWidthX() + bb.getWidthZ()) / 2.0;
				BlockData bd = getBlood(le);
				le.getWorld().spawnParticle(Particle.BLOCK_CRACK, le.getLocation().add(0, heightAdd, 0), 25, width/3.0, heightAdd/2.0, width/3.0, 0.005, bd);
				if(bloodDropsE) {
			if(isNotSolid(le.getLocation().getBlock().getLocation(), true)&&(!(isNotSolid(le.getLocation().getBlock().getLocation().subtract(0, 1, 0), false)))) {
					if(bd.getMaterial() == Material.NETHER_WART_BLOCK) {
					Block b = le.getLocation().getBlock();
					b.setType(Material.REDSTONE_WIRE);
					b.setMetadata("blood", new FixedMetadataValue(this, 0));
					}
				}
				}
			}
		}
		}
	}
	
	public BlockData getBlood(LivingEntity le) {
		BlockData bd = Material.NETHER_WART_BLOCK.createBlockData();
		if(le instanceof Creeper) {
			bd = Material.LIME_CONCRETE_POWDER.createBlockData();
		}
		else if(le instanceof WitherSkeleton || le instanceof Wither) {
			bd = Material.COAL_BLOCK.createBlockData();
		}
		else if(le instanceof Skeleton || le instanceof SkeletonHorse) {
			bd = Material.BONE_BLOCK.createBlockData();
		}
		else if(le instanceof MagmaCube) {
			bd = Material.MAGMA_BLOCK.createBlockData();
		}
		else if(le instanceof Blaze) {
			bd = Material.FIRE.createBlockData();
		}
		else if(le instanceof Slime) {
			bd = Material.SLIME_BLOCK.createBlockData();
		}
		else if(le instanceof Shulker) {
			bd = Material.SHULKER_BOX.createBlockData();
		}
		return bd;
	}

	@EventHandler
	public void onEntityDeath(EntityDeathEvent e) {
		if(isNotWorld(e.getEntity())) {
			return;
		}
		if(worlds.contains(e.getEntity().getWorld().getName()) && dropsE) {
			if(inSpawnRegion(e.getEntity().getLocation())) {
				return;
			}
		if(e.getEntity() instanceof Player) {
			return;
		}
		else {
			if(e.getEntity() instanceof Lootable && e.getEntity() instanceof LivingEntity) {
				if(e.getEntity().hasMetadata("dropped")) {
					e.getDrops().clear();
				}
				if(e.getEntity() instanceof Spider) {
					if(randor.nextInt(4)==0) {
					e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), new ItemStack(Material.SPIDER_EYE, 1));
					}
				}
			}
		}
		}
	}
	
	@EventHandler
	public void onMobDamageFromPlayer(EntityDamageByEntityEvent e) {
		if(isNotWorld(e.getEntity()) || (nau && (!e.getEntity().hasMetadata("natural")))) {
			return;
		}
		if(worlds.contains(e.getEntity().getWorld().getName()) && dropsE) {
		if(inSpawnRegion(e.getEntity().getLocation()) || e.isCancelled() || e.getEntity().isInvulnerable() || e.getEntity().hasMetadata("darkness")) {
			return;
		}
		if(e.getEntity() instanceof LivingEntity && e.getDamager() instanceof LivingEntity && (!(e.getEntity() instanceof Player))) {
			if(e.getEntity() instanceof Lootable) {
			int looting = 0;
			if(e.getDamager() instanceof Player) {
				Player p = (Player) e.getDamager();
				if(limbo.contains(p.getName())) {
					return;
				}
				ItemStack i = p.getInventory().getItemInMainHand();
				if(i != null) {
					if(i.containsEnchantment(Enchantment.LOOT_BONUS_MOBS)) {
						looting = i.getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);
					}
				}
			}
			LivingEntity mob = (LivingEntity) e.getEntity();
			int chance = (int) (9 - (e.getFinalDamage() + 1 + looting));
			if(chance <= 0) {
				chance = 1;
			}
			int choice = randor.nextInt(chance);
					
			if(choice==0) {
				if(mob.hasMetadata("player") || mob instanceof IronGolem || mob instanceof Drowned || mob instanceof WitherSkeleton || mob instanceof Evoker || mob instanceof Slime || mob instanceof MagmaCube || mob.getType().name().toLowerCase().contains("ravag") || mob instanceof Shulker || mob instanceof Stray) {
					return;
				}
				else if(mob instanceof Blaze) {
					if(!mob.hasMetadata("dropped")) {
						mob.setMetadata("dropped", new FixedMetadataValue(this, 0));
					}
					mob.getWorld().dropItemNaturally(mob.getLocation(), new ItemStack(Material.BLAZE_ROD, 1));
				}
				else {
				LootTable lt = ((Lootable) mob).getLootTable();
				LootContext.Builder bd = new LootContext.Builder(mob.getLocation());
				Builder b = bd;
				if(e.getDamager() instanceof Player) {
					b = b.killer((HumanEntity) e.getDamager());
				}
				b = b.lootedEntity(mob);
				LootContext lc = b.build();
				
				for(ItemStack i : lt.populateLoot(randor, lc)){
					if(i != null) {
						if(!mob.hasMetadata("dropped")) {
							mob.setMetadata("dropped", new FixedMetadataValue(this, 0));
						}
						mob.getWorld().dropItemNaturally(mob.getLocation(), new ItemStack(i.getType(), (randor.nextInt(i.getAmount()))+1));
					}
				}
				}
			}
			}
		}
		}
	}
	
	@EventHandler
	public void onMobDamage(EntityDamageEvent e) {
		if(isNotWorld(e.getEntity()) || (nau && (!e.getEntity().hasMetadata("natural")))) {
			return;
		}
		if(worlds.contains(e.getEntity().getWorld().getName()) && dropsE) {
			if(inSpawnRegion(e.getEntity().getLocation()) || e.isCancelled() || e.getEntity().isInvulnerable() || e.getEntity().hasMetadata("darkness")) {
				return;
			}
		if(e.getEntity() instanceof LivingEntity && (!(e.getEntity() instanceof Player))) {
			if(e.getCause() == DamageCause.ENTITY_ATTACK || e.getCause() == DamageCause.ENTITY_SWEEP_ATTACK) {
				return;
			}
			if(e.getEntity() instanceof Lootable) {
				
				LivingEntity mob = (LivingEntity) e.getEntity();
				int chance = (int) (9 - (e.getFinalDamage() + 1));
				if(chance <= 0) {
					chance = 1;
				}
				int choice = randor.nextInt(chance);
						
				if(choice==0) {
					if(mob.hasMetadata("player") || mob instanceof IronGolem || mob instanceof Drowned || mob instanceof WitherSkeleton || mob instanceof Evoker || mob instanceof Slime || mob instanceof MagmaCube || mob.getType().name().toLowerCase().contains("ravag") || mob instanceof Shulker || mob instanceof Stray) {
						return;
					}
					else if(mob instanceof Blaze) {
						if(!mob.hasMetadata("dropped")) {
							mob.setMetadata("dropped", new FixedMetadataValue(this, 0));
						}
						mob.getWorld().dropItemNaturally(mob.getLocation(), new ItemStack(Material.BLAZE_ROD, 1));
					}
					else {
					LootTable lt = ((Lootable) mob).getLootTable();
					LootContext.Builder bd = new LootContext.Builder(mob.getLocation());
					Builder b = bd;
					b = b.lootedEntity(mob);
					LootContext lc = b.build();
					
					for(ItemStack i : lt.populateLoot(randor, lc)){
						if(i != null) {
							if(!mob.hasMetadata("dropped")) {
								mob.setMetadata("dropped", new FixedMetadataValue(this, 0));
							}
							mob.getWorld().dropItemNaturally(mob.getLocation(), new ItemStack(i.getType(), (randor.nextInt(i.getAmount()))+1));
						}
					}
					}
				}
				}
		}
		}
	}
	
	///////////////////////////////////////////////////
	
	//Enhanced Monsters
	
	List<Creeper> creepers = new ArrayList<Creeper>();
	List<Player> slimed = new ArrayList<Player>();
	
	public void targeted(LivingEntity monster, LivingEntity player) {
		//add speed
		if(isNotWorld(monster)) {
			return;
		}
		if(monster.hasMetadata("cavem") || monster.hasMetadata("darkness")) {
			return;
		}
		if(monstersE) {
		if(monster instanceof Zombie) {
			addPotionEffectBetter(monster, PotionEffectType.SPEED, 999999, 0, false, false, false);
		}
		if(monster instanceof Spider) {
			addPotionEffectBetter(monster, PotionEffectType.SPEED, 999999, 1, false, false, false);
		}
		}
		//sounds
		if(monster instanceof Husk) {
			monster.getWorld().playSound(monster.getLocation(), Sound.ENTITY_HUSK_AMBIENT, (float) 2, (float) 0.7);
		}
		else if(monster instanceof Stray) {
			monster.getWorld().playSound(monster.getLocation(), Sound.ENTITY_STRAY_AMBIENT, (float) 2, (float) 0.7);
		}
		else if(monster instanceof WitherSkeleton) {
			monster.getWorld().playSound(monster.getLocation(), Sound.ENTITY_WITHER_SKELETON_AMBIENT, (float) 2, (float) 0.7);
		}
		else if(monster instanceof Zombie) {
			monster.getWorld().playSound(monster.getLocation(), Sound.ENTITY_ZOMBIE_AMBIENT, (float) 2, (float) 0.7);
		}
		else if(monster instanceof Skeleton) {
			monster.getWorld().playSound(monster.getLocation(), Sound.ENTITY_SKELETON_AMBIENT, (float) 2, (float) 0.7);
		}
		else if(monster instanceof Creeper) {
			monster.getWorld().playSound(monster.getLocation(), Sound.ENTITY_CREEPER_PRIMED, (float) 2, (float) 0.7);
		}
		else if(monster instanceof Spider) {
			monster.getWorld().playSound(monster.getLocation(), Sound.ENTITY_SPIDER_AMBIENT, (float) 2, (float) 0.7);
		}
		//alerting other monsters
		alertMonsters(monster, player);
		//add creepers to list
		if(monstersE) {
		if(monster instanceof Creeper) {
			creepers.add(((Creeper) monster));
		}
		}
	}
	
	public void alertMonsters(LivingEntity monster, LivingEntity target) {
		List<Entity> entitiesAround = new ArrayList<Entity>(monster.getWorld().getNearbyEntities(monster.getLocation(), 16, 16, 16));
		for(Entity e : entitiesAround) {
			if(e instanceof Monster) {
				Monster m = (Monster) e;
				if((!(m instanceof Enderman)) || (monster instanceof Enderman && m instanceof Enderman)) {
					if(m != monster) {
						if(!m.hasMetadata("cavem")) {
							if(m.getTarget() != null) {
								if(m.getTarget().isDead()) {
									m.setTarget(target);
								}
							}
							else {
								m.setTarget(target);
							}
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void wasHit(EntityDamageByEntityEvent event) {
		if(isNotWorld(event.getEntity())) {
			return;
		}
		if(worlds.contains(event.getEntity().getWorld().getName()) && monstersE) {
		if(event.getEntity() instanceof Player) {
		Player damaged = (Player) event.getEntity();
		if(limbo.contains(damaged.getName()) || event.isCancelled()) {
			return;
		}
		if (event.getDamager() instanceof MagmaCube) {
			MagmaCube attacker = (MagmaCube) event.getDamager();
			if(attacker.getCustomName()!=null) {
				return;
			}
			if(randor.nextBoolean()) {
				damaged.setFireTicks(80);
			}
		}
		else if (event.getDamager() instanceof Slime) {
			Slime attacker = (Slime) event.getDamager();
			if(attacker.getCustomName()!=null) {
				return;
			}
			if (randor.nextInt(10) < 6) {
				slimeEntity(damaged, 0);
				damaged.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 60, 1));
			}
		}
		else if (event.getDamager() instanceof Enderman) {
			Enderman attacker = (Enderman) event.getDamager();
			if(attacker.getCustomName()!=null) {
				return;
			}
			if (randor.nextInt(10) < 6) {
				Location l = getRandLoc(damaged.getLocation().add(0, 1, 0), 1);
				damaged.teleport(l);
				damaged.getWorld().playSound(l, Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
				damaged.getWorld().spawnParticle(Particle.SPELL_WITCH, l, 25, 0.4, 1, 0.4, 0.0001);
			}
		}
		else if (event.getDamager() instanceof Spider) {
			Spider attacker = (Spider) event.getDamager();
			if(attacker.getCustomName()!=null) {
				return;
			}
			if (randor.nextInt(10) < 3) {
				Location loc = damaged.getLocation();
				loc.getBlock().setType(Material.COBWEB);
				loc.getWorld().spawnParticle(Particle.BLOCK_CRACK, loc.getBlock().getLocation().add(.5, .5, .5), 20, .3, .3, .3, 0, Material.COBWEB.createBlockData());
				loc.getWorld().spawnParticle(Particle.CLOUD, loc.getBlock().getLocation().add(0.5, 0.5, 0.5), 20, 0, 0, 0, 0.05);
			} 
			else {
				if (randor.nextInt(10) < 6) {
					damaged.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 50, 1));
				}
			}
		}
		else if (event.getDamager() instanceof Husk) {
			Husk attacker = (Husk) event.getDamager();
			if(attacker.hasMetadata("player")) {
				event.setCancelled(true);
				return;
			}
			if(attacker.getCustomName()!=null) {
				return;
			}
			if (randor.nextInt(10) < 5) {
				if(!damaged.getLocation().subtract(0, 1, 0).getBlock().isPassable()) {
				downEntity(damaged, 0, damaged.getLocation().clone());
				}
			}
			else {
				if (randor.nextInt(10) < 6) {
					addPotionEffectBetter(damaged, PotionEffectType.HUNGER, 100, 1, false, false, true);
				}
			}
		}
		else if (event.getDamager() instanceof Projectile) {
			Projectile attacker = (Projectile) event.getDamager();
			if(attacker.getShooter() instanceof Stray){
				Monster m = (Monster) attacker.getShooter();
				if(m.getCustomName()!=null) {
					return;
				}
				if (randor.nextInt(10) < 3) {
					Location loc = damaged.getLocation().getBlock().getLocation();
					damaged.teleport(loc.clone().add(0.5, 0, 0.5));
					loc.clone().add(0, 1, 0).getBlock().getRelative(BlockFace.SOUTH).setType(Material.ICE);
					loc.clone().add(0, 1, 0).getBlock().getRelative(BlockFace.EAST).setType(Material.ICE);
					loc.clone().add(0, 1, 0).getBlock().getRelative(BlockFace.WEST).setType(Material.ICE);
					loc.clone().add(0, 1, 0).getBlock().getRelative(BlockFace.NORTH).setType(Material.ICE);
					loc.clone().add(0, 1, 0).getBlock().getRelative(BlockFace.DOWN).setType(Material.ICE);
					loc.clone().add(0, 1, 0).getBlock().getRelative(BlockFace.SELF).setType(Material.ICE);
					loc.getWorld().playSound(loc, Sound.BLOCK_GLASS_BREAK, 1, (float) 1.3);
					for(int i = 0; i < 24; i++) {
						final Location loc2 = loc.clone();
						int randtime = randor.nextInt(10)+5;
						Bukkit.getScheduler().runTaskLater(this, () -> loc2.getWorld().playSound(loc2, Sound.BLOCK_GLASS_BREAK, 1, (float) 1.3), randtime);
						Bukkit.getScheduler().runTaskLater(this, () -> loc2.add(randor.nextInt(4)-1, randor.nextInt(4)-1, randor.nextInt(4)-1).getBlock().setType(Material.ICE), randtime);
					}
				} 
				else {
					if (randor.nextInt(10) < 5) {
						addPotionEffectBetter(damaged, PotionEffectType.SLOW, 60, 3, false, false, true);
					}
				}
            }
		}
		}
		}
	}
	
	public void slimeEntity(LivingEntity e, int count) {
		if(count > 60 || e == null) {
			return;
		}
		if(e.isDead()) {
			return;
		}
		e.getWorld().spawnParticle(Particle.BLOCK_CRACK, e.getLocation().add(0, 1, 0), 2, .4, .5, .4, 0, Material.SLIME_BLOCK.createBlockData());
		Bukkit.getScheduler().runTaskLater(this, () -> slimeEntity(e, count+1), 1);
	}
	
	public void downEntity(LivingEntity e, int count, Location loc) {
		if(count > 10 || e == null) {
			return;
		}
		if(e.isDead()) {
			return;
		}
		e.getWorld().playSound(e.getLocation(), Sound.BLOCK_SAND_BREAK, 1, (float) 0.8);
		e.getWorld().spawnParticle(Particle.BLOCK_CRACK, loc, 4, .2, 0, .2, 0, loc.subtract(0, 0.05, 0).getBlock().getType().createBlockData());
		e.teleport(loc.subtract(0, .05, 0));
		Bukkit.getScheduler().runTaskLater(this, () -> downEntity(e, count+1, loc), 1);
	}
	
	public void doCreeperEffects() {
		List<Creeper> creepersCopy = new ArrayList<Creeper>(creepers);
		for(Creeper c : creepersCopy) {
			if(canDoMonsterEffect(c)) {
				if(randor.nextInt(4)==0) {
					LivingEntity target = c.getTarget();
					if(!c.getLocation().subtract(0, 1, 0).getBlock().isPassable() && getLookingAt(c, target)) {
						c.getWorld().playSound(c.getLocation(), Sound.ENTITY_HORSE_BREATHE, 1, (float) 1.2);
						Vector v = target.getLocation().toVector().subtract(c.getLocation().toVector()).normalize();
						c.setVelocity(c.getVelocity().add(v));
					}
				}
			}
			else {
				creepers.remove(c);
			}
		}
	}
	
	public boolean canDoMonsterEffect(Monster m) {
		if(m == null) {
			return false;
		}
		if(m.isDead()) {
			return false;
		}
		if(m.getTarget() == null) {
			return false;
		}
		if(m.getTarget().isDead()) {
			return false;
		}
		return true;
	}
	
	@EventHandler
	public void monsterSpawnEvent(EntitySpawnEvent e) {
		if(worlds.contains(e.getEntity().getWorld().getName()) && monstersE) {
		if(e.getEntity() instanceof Monster) {
			((Monster) e.getEntity()).getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(config.getInt("monsterViewDistance "));
		}
		}
	}
	
	///////////////////////////////////////////////////
	
	//Better Fall Damage
	
	@EventHandler
	public void playerDamage(EntityDamageEvent e) {
		if(isNotWorld(e.getEntity())) {
			return;
		}
		if(e.getEntity().isInvulnerable() || inSpawnRegion(e.getEntity().getLocation())) {
			if(e.getEntity().isInvulnerable() || e.getEntity() instanceof Player) {
			e.setCancelled(true);
			}
			return;
		}
		if(worlds.contains(e.getEntity().getWorld().getName()) && fallE) {
		if(e.getCause() == DamageCause.FALL) {
			if(e.getEntity() instanceof LivingEntity) {
				if(e.getEntity() instanceof Silverfish || e.getEntity() instanceof ArmorStand || e.isCancelled()) {
					return;
				}
				if(e.getEntity() instanceof Player) {
					if(limbo.contains(((Player) e.getEntity()).getName())) {
						return;
					}
				}
				LivingEntity le = (LivingEntity) e.getEntity();
				Location l = le.getLocation().subtract(0, 1, 0);
				if(l.getBlock().getType()==Material.HAY_BLOCK) {
					e.setDamage(e.getFinalDamage()/3.5);
				}
				else if(l.getBlock().getType().name().toLowerCase().contains("wool")) {
					e.setDamage(e.getFinalDamage()/2.0);
				}
				else if(l.getBlock().getType().name().toLowerCase().contains("bed")) {
					e.setDamage(e.getFinalDamage()/3.0);
				}
				else if(l.getBlock().getType().name().toLowerCase().contains("leave")) {
					e.setDamage(e.getFinalDamage()/3.0);
				}
				else if(l.getBlock().getType().name().toLowerCase().contains("ice")||l.getBlock().getType().name().toLowerCase().contains("ice")) {
					e.setDamage(e.getFinalDamage()/1.25);
					if(randor.nextBoolean()) {
					l.getBlock().setType(Material.AIR);
					l.getWorld().playSound(l, Sound.BLOCK_GLASS_BREAK, 1, 1);
					}
				}
				if(bloodE) {
				if(le.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
					return;
				}
					le.getWorld().playSound(le.getLocation(), Sound.BLOCK_LAVA_POP, 1, 2);
					BoundingBox bb = le.getBoundingBox();
					double heightAdd = bb.getHeight() / 2.0;
					double width = (bb.getWidthX() + bb.getWidthZ()) / 2.0;
					BlockData bd = getBlood(le);
					le.getWorld().spawnParticle(Particle.BLOCK_CRACK, le.getLocation().add(0, heightAdd, 0), 25, width/3.0, heightAdd/2.0, width/3.0, 0.005, bd);
					if(bloodDropsE) {
				if(isNotSolid(le.getLocation().getBlock().getLocation(), true)&&(!(isNotSolid(le.getLocation().getBlock().getLocation().subtract(0, 1, 0), false)))) {
						if(bd.getMaterial() == Material.NETHER_WART_BLOCK) {
						Block b = le.getLocation().getBlock();
						b.setType(Material.REDSTONE_WIRE);
						b.setMetadata("blood", new FixedMetadataValue(this, 0));
					}
				}
				}
				}
				if(e.getFinalDamage() >= 7) {
				addPotionEffectBetter(le, PotionEffectType.SLOW, 40, 10, false, false, false);
				}
			}
		}
		}
	}

	///////////////////////////////////////////////////
	
	//Headshots
	
	@EventHandler
	public void onArrowHit(ProjectileHitEvent event) {
		if(worlds.contains(event.getEntity().getWorld().getName()) && headshotsE) {
		if(event.getHitEntity()!=null) {
			if(inSpawnRegion(event.getHitEntity().getLocation())) {
				return;
			}
			if(event.getEntity() instanceof Arrow) {
				if(event.getHitEntity() instanceof LivingEntity) {
					LivingEntity enti = (LivingEntity) event.getHitEntity();
					if(enti instanceof Player||enti instanceof Zombie||enti instanceof Skeleton||enti instanceof Creeper||enti instanceof Husk||enti instanceof Stray||enti instanceof Villager||enti instanceof Witch|| enti instanceof Illager) {
						if(event.getEntity().getLocation().getY()>enti.getLocation().getY()+1.45) {
							if(!(enti instanceof Player)) {
							enti.damage(12);
							}
							else {
								double damag = 12;
								Player p = (Player) enti;
								if(limbo.contains(p.getName())) {
									return;
								}
								if(p.getInventory().getHelmet()!=null) {
									if(p.getInventory().getHelmet().getType()==Material.LEATHER_HELMET) {
										damag = damag - 5;
										enti.damage(damag);
									}
									else {
										if(p.getInventory().getHelmet().getType()==Material.DIAMOND_HELMET) {
											p.getWorld().playSound(new Location(p.getWorld(), enti.getLocation().getX(), enti.getLocation().getY()+1.35, enti.getLocation().getZ()), Sound.BLOCK_ANVIL_LAND, 1, 1);
											p.getWorld().spawnParticle(Particle.BLOCK_CRACK, enti.getLocation().getX(), enti.getLocation().getY()+1.35, enti.getLocation().getZ(), 25, Material.DIAMOND_BLOCK.createBlockData());
										}
										else if(p.getInventory().getHelmet().getType()==Material.GOLDEN_HELMET) {
											p.getWorld().playSound(new Location(p.getWorld(), enti.getLocation().getX(), enti.getLocation().getY()+1.35, enti.getLocation().getZ()), Sound.BLOCK_ANVIL_LAND, 1, 1);
											p.getWorld().spawnParticle(Particle.BLOCK_CRACK, enti.getLocation().getX(), enti.getLocation().getY()+1.35, enti.getLocation().getZ(), 25, Material.GOLD_BLOCK.createBlockData());
										}
										else if(p.getInventory().getHelmet().getType()==Material.IRON_HELMET) {
											p.getWorld().playSound(new Location(p.getWorld(), enti.getLocation().getX(), enti.getLocation().getY()+1.35, enti.getLocation().getZ()), Sound.BLOCK_ANVIL_LAND, 1, 1);
											p.getWorld().spawnParticle(Particle.BLOCK_CRACK, enti.getLocation().getX(), enti.getLocation().getY()+1.35, enti.getLocation().getZ(), 25, Material.IRON_BLOCK.createBlockData());
										}	
										return;
									}
								}
								else {
									enti.damage(damag);
								}
							}
							if(enti instanceof WitherSkeleton) {
								return;
							}
							if(!(enti instanceof Skeleton||enti instanceof Creeper||enti instanceof Stray)) {
								enti.getWorld().playSound(new Location(enti.getWorld(), enti.getLocation().getX(), enti.getLocation().getY()+1.35, enti.getLocation().getZ()), Sound.ENTITY_GUARDIAN_FLOP, 1, 1);
								enti.getWorld().spawnParticle(Particle.BLOCK_CRACK, enti.getLocation().getX(), enti.getLocation().getY()+1.35, enti.getLocation().getZ(), 25, Material.NETHER_WART_BLOCK.createBlockData());
							}
							else if(enti instanceof Creeper) {
								enti.getWorld().playSound(new Location(enti.getWorld(), enti.getLocation().getX(), enti.getLocation().getY()+1.35, enti.getLocation().getZ()), Sound.ENTITY_GUARDIAN_FLOP, 1, 1);
								enti.getWorld().spawnParticle(Particle.BLOCK_CRACK, enti.getLocation().getX(), enti.getLocation().getY()+1.35, enti.getLocation().getZ(), 25, Material.LIME_CONCRETE_POWDER.createBlockData());
							}
							else if(enti instanceof Skeleton||enti instanceof Stray) {
								enti.getWorld().playSound(new Location(enti.getWorld(), enti.getLocation().getX(), enti.getLocation().getY()+1.35, enti.getLocation().getZ()), Sound.ENTITY_SKELETON_AMBIENT, 1, 1);
								enti.getWorld().spawnParticle(Particle.BLOCK_CRACK, enti.getLocation().getX(), enti.getLocation().getY()+1.35, enti.getLocation().getZ(), 25, Material.BONE_BLOCK.createBlockData());
							}
							enti.setVelocity(new Vector(0,0,0));
							enti.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION,60,200));
							event.getEntity().remove();
						}
					}
				}
			}
		}
		}
	}
	
	///////////////////////////////////////////////////
	
	//Desire Paths
	
	public boolean differentBlock(Location to, Location from) {
		if(((int) to.getX())!=((int) from.getX())||((int) to.getY())!=((int) from.getY())||((int) to.getZ())!=((int) from.getZ())){
			return true;
		}
		return false;
	}

	@EventHandler
	public void onPlayerWalk(PlayerMoveEvent e) {
		if(worlds.contains(e.getPlayer().getWorld().getName()) && desirePathE) {
		if(limbo.contains(e.getPlayer().getName()) || e.isCancelled()) {
			return;
		}
		if(inSpawnRegion(e.getPlayer().getLocation())) {
			return;
		}
		if(differentBlock(e.getTo(), e.getFrom())) {
			Block b = e.getTo().clone().subtract(0, 1, 0).getBlock();
			if(b.getType() == Material.GRASS_BLOCK || b.getType() == Material.COARSE_DIRT || b.getType() == Material.DIRT) {
				if(b.hasMetadata("decay")) {
					if(b.getMetadata("decay").size()>0) {
						int decayAmmount = b.getMetadata("decay").get(0).asInt() + 1;
						decayBlock(b, decayAmmount);
					}
					else {
						b.setMetadata("decay", new FixedMetadataValue(this, 0));
					}
				}
				else {
					b.setMetadata("decay", new FixedMetadataValue(this, 0));
				}
			}
		}
		}
	}
	
	public void decayBlock(Block b, int decayA) {
		if(decayA >= 25) {
			if(randor.nextBoolean()) {
				if(b.getType() == Material.GRASS_BLOCK) {
					b.setType(Material.COARSE_DIRT);
					b.getWorld().playSound(b.getLocation().add(0.5, 0, 0.5), Sound.BLOCK_GRASS_PLACE, 1, 1);
					b.getWorld().spawnParticle(Particle.BLOCK_CRACK, b.getLocation().add(0.5, 1, 0.5), 8, 0.4, 0, 0.4, 0, Material.GRASS_BLOCK.createBlockData());
				}
				else if(b.getType() == Material.COARSE_DIRT) {
					b.setType(Material.GRASS_PATH);
					b.getWorld().playSound(b.getLocation().add(0.5, 0, 0.5), Sound.BLOCK_GRASS_PLACE, 1, 1);
					b.getWorld().spawnParticle(Particle.BLOCK_CRACK, b.getLocation().add(0.5, 1, 0.5), 8, 0.4, 0, 0.4, 0, Material.COARSE_DIRT.createBlockData());
					b.removeMetadata("decay", this);
					return;
				}
				b.setMetadata("decay", new FixedMetadataValue(this, 0));
				return;
			}
		}
		else {
			b.setMetadata("decay", new FixedMetadataValue(this, decayA));
		}
	}
	
	@EventHandler
	public void onPathBreak(BlockBreakEvent e) {
		if(limbo.contains(e.getPlayer().getName())) {
			return;
		}
		Block b = e.getBlock();
		if(b.hasMetadata("decay")) {
			b.removeMetadata("decay", this);
		}
	}
	
	@EventHandler
	public void pistonExtendPath(BlockPistonExtendEvent e) {
		for(Block b : e.getBlocks()) {
			if(b.hasMetadata("decay")) {
				b.removeMetadata("decay", this);
			}
		}
	}
	
	@EventHandler
	public void pistonRetractPath(BlockPistonRetractEvent e) {
		for(Block b : e.getBlocks()) {
			if(b.hasMetadata("decay")) {
				b.removeMetadata("decay", this);
			}
		}
	}
	
	///////////////////////////////////////////////////
	
	//Crops
	
	@EventHandler
	public void onCropsGrow(BlockGrowEvent e) {
		if(worlds.contains(e.getBlock().getWorld().getName()) && cropsE) {
		Material m = e.getBlock().getType();
		if(m == Material.WHEAT || m == Material.POTATOES || m == Material.CARROTS || m == Material.BEETROOTS) {
			int growA = getCropsGrowAmmount(e.getBlock().getLocation());
			if(randor.nextInt(4)!=0) {
				e.setCancelled(true);
			}
		}
		}
	}
	
	public int getCropsGrowAmmount(Location l) {
		int ammount = 5;
		boolean aboveGround = getAboveGround(l.clone().add(0, 1, 0));
		if(aboveGround) {
			if(l.getWorld().isThundering()) {
				ammount -= 1;
			}
			if(!isNight(l.getWorld())) {
				ammount -= 1;
			}
		}
		return ammount;
	}
	
	@EventHandler
	public void onCropsBreak(BlockBreakEvent e) {
		if(worlds.contains(e.getBlock().getWorld().getName()) && cropsE) {
		if(limboE) {
		if(limbo.contains(e.getPlayer().getName())) {
			return;
		}
		}
		if(inSpawnRegion(e.getPlayer().getLocation()) || e.isCancelled()) {
			return;
		}
		Block b = e.getBlock();
		Material m = b.getType();
		if(m == Material.WHEAT || m == Material.POTATOES || m == Material.CARROTS || m == Material.BEETROOTS) {
			if(((Ageable) b.getBlockData()).getAge()>=((Ageable) m.createBlockData()).getMaximumAge()) {
				List<ItemStack> drops = new ArrayList<ItemStack>();
				if(e.getPlayer().getInventory().getItemInMainHand()!=null) {
					for(ItemStack i : e.getBlock().getDrops(e.getPlayer().getInventory().getItemInMainHand())) {
						drops.add(new ItemStack(i.getType(), i.getAmount() * 4));
					}
				}
				else {
					for(ItemStack i : e.getBlock().getDrops()) {
						drops.add(new ItemStack(i.getType(), i.getAmount() * 4));
					}
				}
				for(ItemStack i : drops) {
					b.getWorld().dropItemNaturally(b.getLocation().add(0.5, 0, 0.5), i);
				}
			}
		}
		}
	}
	
	///////////////////////////////////////////////////
	
	List<Entity> playersWhoSwitched = new ArrayList<Entity>();
	
	//Any block on head
	
	@EventHandler
	public void onPlayerJoinRemove(PlayerJoinEvent e) {
		if(worlds.contains(e.getPlayer().getWorld().getName()) && headE) {
		if(playersWhoSwitched.contains(e.getPlayer())) {
			playersWhoSwitched.remove(e.getPlayer());
		}
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerClickInInventory(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if(worlds.contains(p.getWorld().getName()) && headE) {
			if(limboE) {
		if(limbo.contains(p.getName())) {
			return;
		}
			}
		if(!playersWhoSwitched.contains(p)) {
		if(e.getClickedInventory()!=null) {
		if(e.getClickedInventory().getType()==InventoryType.PLAYER) {
			int slot = e.getSlot();
			if(slot == 39) {
			if(((e.getAction() == InventoryAction.SWAP_WITH_CURSOR || e.getAction() == InventoryAction.NOTHING || e.getAction() == InventoryAction.PLACE_ONE) && e.getClick() == ClickType.RIGHT)||((e.getAction() == InventoryAction.PLACE_ALL || e.getAction() == InventoryAction.NOTHING || e.getAction() == InventoryAction.PLACE_ONE) && e.getClick() == ClickType.LEFT)) {
				e.setCancelled(true);
				playersWhoSwitched.add(p);
				ItemStack itemInSlot = e.getClickedInventory().getItem(slot);
				Bukkit.getScheduler().runTaskLater(this, () -> continueEquip(e, slot, e.getCursor(), itemInSlot, p), 2);
			}
			}
		}
		}
		}
		}
	}
	
	public void continueEquip(InventoryClickEvent e, int slot, ItemStack cursor, ItemStack slotItem, Player p) {
		if(playersWhoSwitched.contains(p)) {
			boolean doSomething = true;
			if(slotItem != null) {
				if(slotItem.clone().getType().name().toLowerCase().contains("helmet")) {
					doSomething = false;
				}
			}
		if(doSomething) {
		if(cursor != null) {
			if(cursor.getAmount()==1 && (!cursor.clone().getType().name().toLowerCase().contains("helmet"))) {
				e.getClickedInventory().setItem(slot, null);
				p.getInventory().setHelmet(cursor.clone());
			}
			else {
				doSomething = false;
			}
		}
		}
		if(doSomething) {
			if(slotItem != null) {
				e.setCursor(slotItem.clone());
			}
			else {
				e.setCursor(new ItemStack(Material.AIR));
			}
		}
		Bukkit.getScheduler().runTaskLater(this, () -> playersWhoSwitched.remove(p), 2);
		}
	}
	
	///////////////////////////////////////////////////
	
	//Multi Break Blocks
	
	@EventHandler
	public void onPlayerMineMultiLevel(BlockBreakEvent e) {
		// if silk touch, return
		Player p = e.getPlayer();
		if(worlds.contains(p.getWorld().getName()) && stageE) {
		if(limboE) {
			if(limbo.contains(p.getName())) {
				return;
			}
		}
		if(inSpawnRegion(p.getLocation()) || e.isCancelled()) {
			return;
		}
		if(p.getInventory().getItemInMainHand()!=null) {
			if(p.getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
				return;
			}
		}
		Block b = e.getBlock();
		Material m = e.getBlock().getType();
		if(m == Material.GRASS_BLOCK) {
			e.setCancelled(true);
			b.setType(Material.DIRT);
		}
		else if(m == Material.TALL_GRASS) {
			if(((Bisected) b.getBlockData()).getHalf() == Half.TOP) {
				b.getLocation().subtract(0, 1, 0).getBlock().setType(Material.GRASS);
			}
			else {
				Bukkit.getScheduler().runTaskLater(this, () -> b.setType(Material.GRASS), 2);
			}
		}
		else if(m == Material.STONE) {
			e.setCancelled(true);
			if(isAir(b.getLocation().subtract(0, 1, 0).getBlock().getType())) {
				b.setType(Material.GRAVEL);
			}
			else {
				b.setType(Material.COBBLESTONE);
			}
		}
		else if(m == Material.POLISHED_ANDESITE) {
			e.setCancelled(true);
			b.setType(Material.ANDESITE);
		}
		else if(m == Material.POLISHED_DIORITE) {
			e.setCancelled(true);
			b.setType(Material.DIORITE);
		}
		else if(m == Material.POLISHED_GRANITE) {
			e.setCancelled(true);
			b.setType(Material.GRANITE);
		}
		else if(m == Material.SANDSTONE) {
			e.setCancelled(true);
			b.setType(Material.SAND);
		}
		}
	}
	
	///////////////////////////////////////////////////
	
	//Leaves drop sticks and bird nests
	
	@EventHandler
	public void onPlayerPlaceLeaves(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if(worlds.contains(e.getPlayer().getWorld().getName()) && leavesE) {
		if(limboE) {
		if(limbo.contains(p.getName())) {
			return;
		}
		}
		if(e.getBlock().getType().name().toLowerCase().contains("leave")) {
			e.getBlock().setMetadata("pp", new FixedMetadataValue(this, 0));
		}
		}
	}
	
	@EventHandler
	public void onLeavesBreak(BlockBreakEvent e) {
		if(worlds.contains(e.getPlayer().getWorld().getName()) && leavesE) {
		if(limboE) {
		if(limbo.contains(e.getPlayer().getName())) {
			return;
		}
		}
		if(inSpawnRegion(e.getPlayer().getLocation()) || e.isCancelled()) {
			return;
		}
		if(e.getBlock().getType().name().toLowerCase().contains("leave")) {
			if(e.getBlock().hasMetadata("pp")) {
				e.getBlock().removeMetadata("pp", this);
				return;
			}
			else {
				if(randor.nextInt(60)==0) {
					if(e.getBlock().getType() != Material.SPRUCE_LEAVES) {
						ItemStack eggs = new ItemStack(Material.EGG, randor.nextInt(3)+4);
						ItemStack sticks = new ItemStack(Material.STICK, randor.nextInt(11)+10);
						ItemStack feathers = new ItemStack(Material.FEATHER, randor.nextInt(6)+4);
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0.5, 0, 0.5), eggs);
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0.5, 0, 0.5), sticks);
						e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0.5, 0, 0.5), feathers);
						e.getBlock().getWorld().playSound(e.getBlock().getLocation(), Sound.ENTITY_PARROT_HURT, 1, 2);
						Bukkit.getScheduler().runTaskLater(this, () -> e.getBlock().getWorld().playSound(e.getBlock().getLocation(), Sound.ENTITY_PARROT_FLY, 1, (float) 0.9), 5);
					}
				}
				else if(randor.nextInt(4)==0) {
					e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0.5, 0, 0.5), new ItemStack(Material.STICK, 1));
				}
			}
		}
		}
	}
	
	@EventHandler
	public void pistonExtendLeaves(BlockPistonExtendEvent e) {
		for(Block b : e.getBlocks()) {
			if(b.hasMetadata("pp")) {
				b.removeMetadata("pp", this);
			}
		}
	}
	
	@EventHandler
	public void pistonRetractLeaves(BlockPistonRetractEvent e) {
		for(Block b : e.getBlocks()) {
			if(b.hasMetadata("pp")) {
				b.removeMetadata("pp", this);
			}
		}
	}
	
	///////////////////////////////////////////////////
	
	//Anvil Colors
	
	@EventHandler
	public void onAnvilColor(PrepareAnvilEvent event) {
		if(worlds.contains(event.getInventory().getLocation().getWorld().getName()) && colorE) {
		boolean doColor = false;
		ItemStack item = null;
		ItemStack dye = null;
		for(ItemStack i : event.getInventory().getContents()) {
			if(i!=null) {
				Material m = i.getType();
			if(m.name().toLowerCase().contains("dye")) {
				doColor=true;
				dye = i;
			}
			else {
				item = i;
			}
			}
		}
		if(doColor==false||item==null) {
			return;
		}
		else {
			ItemStack newItem = item.clone();
			Material m = dye.getType();
			ItemMeta im = newItem.getItemMeta();
			String rename = event.getInventory().getRenameText();
			if(rename.equals("")) {
				boolean hasDisplay = false;
				if(newItem.hasItemMeta()) {
					if(newItem.getItemMeta().hasDisplayName()) {
						rename = newItem.getItemMeta().getDisplayName();
						if(!rename.equals("")) {
						hasDisplay = true;
						}
					}
				}
				if(hasDisplay == false) {
				rename = getNormalName(newItem.getType().name().replace("_", " ").toLowerCase());
				}
			}
				if(m.name().toLowerCase().contains("black")) {
					im.setDisplayName("§0"+rename);
				}
				else if(m.name().toLowerCase().contains("red")) {
					im.setDisplayName("§4"+rename);
				}
				else if(m.name().toLowerCase().contains("green")) {
					im.setDisplayName("§2"+rename);
				}
				else if(m.name().toLowerCase().contains("light_blue")) {
					im.setDisplayName("§b"+rename);
				}
				else if(m.name().toLowerCase().contains("purple")) {
					im.setDisplayName("§5"+rename);
				}
				else if(m.name().toLowerCase().contains("cyan")) {
					im.setDisplayName("§3"+rename);
				}
				else if(m.name().toLowerCase().contains("light_gray")) {
					im.setDisplayName("§7"+rename);
				}
				else if(m.name().toLowerCase().contains("gray")) {
					im.setDisplayName("§8"+rename);
				}
				else if(m.name().toLowerCase().contains("pink")) {
					im.setDisplayName("§c"+rename);
				}
				else if(m.name().toLowerCase().contains("lime")) {
					im.setDisplayName("§a"+rename);
				}
				else if(m.name().toLowerCase().contains("yellow")) {
					im.setDisplayName("§e"+rename);
				}
				else if(m.name().toLowerCase().contains("blue")) {
					im.setDisplayName("§1"+rename);
				}
				else if(m.name().toLowerCase().contains("magenta")) {
					im.setDisplayName("§d"+rename);
				}
				else if(m.name().toLowerCase().contains("orange")) {
					im.setDisplayName("§6"+rename);
				}
				else if(m.name().toLowerCase().contains("white")) {
					im.setDisplayName("§f"+rename);
				}
			newItem.setItemMeta(im);
			//event.getInventory().setRepairCost(10);
			event.setResult(newItem);
			Bukkit.getScheduler().runTaskLater(this, () -> event.getInventory().setRepairCost(10), 1);
		}
		}
	}
	
	public String getNormalName(String name) {
		String copy = "";
		char previous = ' ';
		if(name.length()>0) {
			for(int count = 0; count < name.length(); count++) {
			char chara = name.charAt(count);
			if(count == 0) {
				chara = Character.toUpperCase(chara);
			}
			else {
				if(previous == ' ' && chara != ' ') {
					chara = Character.toUpperCase(chara);
				}
			}
			copy += chara;
			previous = chara;
			}
		}
		return copy;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerClickInAnvil(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if(worlds.contains(p.getWorld().getName()) && colorE) {
		if(e.getClickedInventory()!=null && p.getLevel()>=10) {
			if(e.getClickedInventory().getType()==InventoryType.ANVIL) {
				if(e.getSlot() == 2) {
				ItemStack one = e.getClickedInventory().getItem(0);
				ItemStack two = e.getClickedInventory().getItem(1);
				if(two == null || one == null) {
					return;
				}
				else {
					int dyecount = 0;
					if(two.getType().name().toLowerCase().contains("dye")) {
						dyecount++;
					}
					if(one.getType().name().toLowerCase().contains("dye")) {
						dyecount++;
					}
					if(dyecount == 1) {
						if(e.getCursor()==null) {
							e.setCursor(e.getClickedInventory().getItem(2));
						}
						else if(e.getCursor().getType() == Material.AIR) {
							e.setCursor(e.getClickedInventory().getItem(2));
						}
						else {
							p.getInventory().addItem(e.getClickedInventory().getItem(2));
						}
						if(two.getType().name().toLowerCase().contains("dye")) {
							e.getClickedInventory().setItem(0, new ItemStack(Material.AIR));
							e.getClickedInventory().setItem(1, removeOne(e.getClickedInventory().getItem(1)));
						}
						else if(one.getType().name().toLowerCase().contains("dye")) {
							e.getClickedInventory().setItem(0, removeOne(e.getClickedInventory().getItem(0)));
							e.getClickedInventory().setItem(1, new ItemStack(Material.AIR));
						}
						e.getClickedInventory().setItem(2, new ItemStack(Material.AIR));
						p.setLevel(p.getLevel()-10);
						p.getWorld().playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1, 1);
					}
					else {
						return;
					}
				}
				}
			}
		}
		}
	}
	
	public ItemStack removeOne(ItemStack i) {
		ItemStack newItem = null;
		if(i == null) {
			newItem = new ItemStack(Material.AIR);
			return newItem;
		}
		else {
			newItem = i.clone();
		}
		int ammount = newItem.getAmount() - 1;
		if(ammount <= 0) {
			newItem.setAmount(0);
			newItem = new ItemStack(Material.AIR);
			return newItem;
		}
		else {
			newItem.setAmount(ammount);
		}
		return newItem;
	}
	
	///////////////////////////////////////////////////
	
	//Limbo
	
	@EventHandler
	public void onBreakLimbo(BlockBreakEvent e) {
		if(limbo.contains(e.getPlayer().getName())) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onPlaceLimbo(BlockPlaceEvent e) {
		if(limbo.contains(e.getPlayer().getName())) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onLimboHurt(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			if(limbo.contains(((Player) e.getEntity()).getName())) {
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onLimboHurtMob(EntityDamageByEntityEvent e) {
		if(e.getEntity() instanceof LivingEntity && e.getDamager() instanceof Player) {
			if(limbo.contains(((Player) e.getDamager()).getName())) {
				e.setCancelled(true);
				if(e.getEntity() instanceof Monster) {
				e.getEntity().remove();
				}
			}
		}
	}
	
	@EventHandler
	public void onPlayerJoinLimbo(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(worlds.contains(p.getWorld().getName()) && limboE) {
		if(limbo.contains(p.getName())) {
			addPotionEffectBetter(p, PotionEffectType.SATURATION, 999999, 100, false, false, false);
			addPotionEffectBetter(p, PotionEffectType.INVISIBILITY, 999999, 1, false, false, false);
		}
		if(!kills.containsKey(p.getName())) {
			kills.put(p.getName(), 0);
			saveConfigs();
		}
		}
	}
	
	@EventHandler
	public void onPlayerDiesAddToLimbo(EntityDeathEvent e) {
		if(e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
		if(artifactsE) {
			List<Integer> abilities = new ArrayList<Integer>(shopGUIS.enabled.get(p.getName()));
			for(Integer i : abilities) {
				disabledAbility(i, p);
			}
			shopGUIS.enabled.get(p.getName()).clear();
			saveConfigs();
		}
		if(worlds.contains(e.getEntity().getWorld().getName()) && limboE) {
		if(parkour.size()>0) {
			if(parkour.get(0) != null) {
			if(parkour.get(0).size()>0) {
			
			Player killer = null;
			if(p.getKiller() != null) {
				killer = p.getKiller();
				addKill(killer.getName(), 1);
			}
			addToLimbo(p.getName());
			int difficulty = kills.get(p.getName())/killsDivider;
			kills.put(p.getName(), 0);
			
			Bukkit.getScheduler().runTaskLater(this, () -> continuteLimbo(p, difficulty), 20);
			}
			}
			}
		}
		}
	}
	
	public void continuteLimbo(Player p, int difficulty) {
		p.spigot().respawn();
		addPotionEffectBetter(p, PotionEffectType.SATURATION, 999999, 100, false, false, false);
		addPotionEffectBetter(p, PotionEffectType.BLINDNESS, 40, 1, false, false, false);
		addPotionEffectBetter(p, PotionEffectType.INVISIBILITY, 999999, 1, false, false, false);
		Location teleport = null;
		if(parkour.containsKey(difficulty)) {
			List<Location> parkourCopy = new ArrayList<Location>(parkour.get(difficulty));
			if(parkourCopy.size()>0) {
				teleport = parkourCopy.get(randor.nextInt(parkourCopy.size()));
			}
		}
		if(teleport == null) {
			if(parkour.size()>0) {
				List<Location> parkourCopy = new ArrayList<Location>(parkour.get(0));
				teleport = parkourCopy.get(randor.nextInt(parkourCopy.size()));
			}
		}
		if(teleport != null) {
			p.teleport(teleport);
		}
	}
	
	@EventHandler
	public void stepOnLimboLeave(PlayerInteractEvent event){
		Player player = event.getPlayer();
		if(worlds.contains(player.getWorld().getName()) && limboE) {
    	if(limbo.contains(player.getName())) {
            if(event.getAction().equals(Action.PHYSICAL)){
                if(event.getClickedBlock().getType() == Material.LIGHT_WEIGHTED_PRESSURE_PLATE){
                	if(player.hasPotionEffect(PotionEffectType.SATURATION)) {
                		player.removePotionEffect(PotionEffectType.SATURATION);
                	}
            		addPotionEffectBetter(player, PotionEffectType.BLINDNESS, 40, 1, false, false, false);
            		if(player.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
            			player.removePotionEffect(PotionEffectType.INVISIBILITY);
            		}
            		addPotionEffectBetter(player, PotionEffectType.INVISIBILITY, 40, 1, false, false, false);
            		if(limbo.contains(player.getName())) {
            			removeLimbo(player.getName());
            		}
            		if(player.getBedSpawnLocation() != null) {
            			Bukkit.getScheduler().runTaskLater(this, () -> player.teleport(player.getBedSpawnLocation()), 2);
            		}
            		else {
            		int randX = (coinFlip() * randor.nextInt(20000));
            		int randZ = (coinFlip() * randor.nextInt(20000));
            		Location l = getSafeToSpawn(new Location(player.getWorld(), randX, 50, randZ), true);
            		for(int count = 0; count < 10; count++) {
            			if(l == null) {
            				randX = (coinFlip() * randor.nextInt(20000));
            				randZ = (coinFlip() * randor.nextInt(20000));
            				l = getSafeToSpawn(new Location(player.getWorld(), randX, 50, randZ), true);
            			}
            			else {
            				break;
            			}
            		}
            		if(l == null) {
            			Bukkit.getScheduler().runTaskLater(this, () -> player.teleport(player.getWorld().getSpawnLocation()), 2);
            		}
            		else {
            			final Location loc = l.clone();
            			Bukkit.getScheduler().runTaskLater(this, () -> player.teleport(loc), 2);
            		}
            		}
            		if(namesE) {
            		addName(player.getName(), getRandomName());
            		}
                }
            }
            }
        }
    }
	
	public boolean safeToSpawn(Location l) {
    	if(isAir(l.clone().getBlock().getType())&&isAir(l.clone().add(0, 1, 0).getBlock().getType())) {
			if(!isAir(l.clone().subtract(0, 1, 0).getBlock().getType())) {
			return true;
			}
		}
    	return false;
    }
    
    public Location getSafeToSpawn(Location l, boolean newL) {
    	Location top = null;
    	if(safeToSpawn(l)) {
    		return l;
    	}
    	else if(l.getY()<200){
    		l.add(0, 1, 0);
    		if(newL) {
    			l.setY(0);
    			return getSafeToSpawn(l, false);
    		}
    		else {
    			return getSafeToSpawn(l, false);
    		}
    	}
    	return null;
    }
	
    public boolean inParkourRegion(Location l) {
    	if(worlds.contains(l.getWorld().getName()) && limboE) {
    	if((Math.max(parkourP1.getX(), parkourP2.getX())>=l.getX())&&((Math.min(parkourP1.getX(), parkourP2.getX())<=l.getX()))) {
    		if((Math.max(parkourP1.getY(), parkourP2.getY())>=l.getY())&&((Math.min(parkourP1.getY(), parkourP2.getY())<=l.getY()))) {
    			if((Math.max(parkourP1.getZ(), parkourP2.getZ())>=l.getZ())&&((Math.min(parkourP1.getZ(), parkourP2.getZ())<=l.getZ()))) {
    	    		return true;
    	    	}
        	}
    	}
    	return false;
    	}
    	return false;
    }
    
    public String getStringofLocation(Location loc){
    	return loc.getBlockX() + "," + loc.getBlockY() + "," + loc.getBlockZ() + "," + loc.getWorld().getName();
    }
    
    public Location getLocation(String what){
    	if(what == null) {
    		return null;
    	}
    	String[] split = what.split(",");
    	if(split.length < 4) {
    		return null;
    	}
    	Location loc = new Location(Bukkit.getWorld(split[3]), Double.parseDouble(split[0]), Double.parseDouble(split[1]), Double.parseDouble(split[2]));
    	return loc;
    }
    
    @EventHandler
    public void entitySpawnEvent(EntitySpawnEvent e) {
    	if(e.getEntity() instanceof Monster) {
    		if(parkourP1 != null) {
    			if(inParkourRegion(e.getEntity().getLocation())) {
    			e.setCancelled(true);
    			}
    		}
    		if(inSpawnRegion(e.getEntity().getLocation())) {
    			e.setCancelled(true);
    		}
    	}
    }
    
	///////////////////////////////////////////////////
    
    //Random Usernames
    
    public void addnames() {
    	firstnames.add("John");
    	firstnames.add("Thomas");
    	firstnames.add("Jeffrey");
    	firstnames.add("Jean");
    	firstnames.add("Amanda");
    	firstnames.add("Charlotte");
    	firstnames.add("Craft");
    	firstnames.add("Simon");
    	firstnames.add("Manuel");
    	firstnames.add("Abigal");
    	firstnames.add("Ivy");
    	firstnames.add("Sam");
    	firstnames.add("Smith");
    	firstnames.add("William");
    	firstnames.add("Noah");
    	firstnames.add("Liam");
    	firstnames.add("James");
    	firstnames.add("Benjamin");
    	firstnames.add("Mason");
    	firstnames.add("Elijah");
    	firstnames.add("Oliver");
    	firstnames.add("Jacob");
    	firstnames.add("Lucas");
    	firstnames.add("Alexander");
    	firstnames.add("Ethan");
    	firstnames.add("Daniel");
    	firstnames.add("Matthew");
    	firstnames.add("Aiden");
    	firstnames.add("Henry");
    	firstnames.add("Joseph");
    	firstnames.add("Jackson");
    	firstnames.add("Samuel");
    	firstnames.add("Sebastian");
    	firstnames.add("David");
    	firstnames.add("Carter");
    	firstnames.add("Wyatt");
    	firstnames.add("Jayden");
    	firstnames.add("Owen");
    	firstnames.add("Dylan");
    	firstnames.add("Luke");
    	firstnames.add("Gabriel");
    	firstnames.add("Lucifer");
    	firstnames.add("Anthony");
    	firstnames.add("Isaac");
    	firstnames.add("Grayson");
    	firstnames.add("Jack");
    	firstnames.add("Julian");
    	firstnames.add("Levi");
    	firstnames.add("Christopher");
    	firstnames.add("Joshua");
    	firstnames.add("Andrew");
    	firstnames.add("Lincoln");
    	firstnames.add("Ryan");
    	firstnames.add("Nathan");
    	/////////////////////////
    	firstnames.add("Emma");
    	firstnames.add("Olivia");
    	firstnames.add("Ava");
    	firstnames.add("Isabella");
    	firstnames.add("Sophia");
    	firstnames.add("Mia");
    	firstnames.add("Amelia");
    	firstnames.add("Evelyn");
    	firstnames.add("Harper");
    	firstnames.add("Emily");
    	firstnames.add("Elizabeth");
    	firstnames.add("Avery");
    	firstnames.add("Sofia");
    	firstnames.add("Ella");
    	firstnames.add("Madison");
    	firstnames.add("Scarlett");
    	firstnames.add("Victoria");
    	firstnames.add("Aria");
    	firstnames.add("Grace");
    	firstnames.add("Chloe");
    	firstnames.add("Camila");
    	firstnames.add("Penelope");
    	firstnames.add("Riley");
    	firstnames.add("Layla");
    	firstnames.add("Lillian");
    	firstnames.add("Nora");
    	firstnames.add("Zoey");
    	firstnames.add("Mila");
    	firstnames.add("Aubrey");
    	firstnames.add("Hannah");
    	firstnames.add("Lily");
    	firstnames.add("Addison");
    	firstnames.add("Eleanor");
    	firstnames.add("Natalie");
    	firstnames.add("Luna");
    	firstnames.add("Savannah");
    	firstnames.add("Brooklyn");
    	firstnames.add("Leah");
    	firstnames.add("Zoe");
    	firstnames.add("Stella");
    	firstnames.add("Hazel");
    	firstnames.add("Ellie");
    	firstnames.add("Paisley");
    	firstnames.add("Audrey");
    	firstnames.add("Skylar");
    	firstnames.add("Violet");
    	firstnames.add("Claire");
    	firstnames.add("Bella");
    	firstnames.add("Aurora");
    	firstnames.add("Lucy");
    	firstnames.add("Anna");
    	firstnames.add("Samantha");
    	firstnames.add("Caroline");
    	firstnames.add("Aaliyah");
    	///////////////////////////
    	lastnames.add("Smith");
    	lastnames.add("Hall");
    	lastnames.add("Vanzin");
    	lastnames.add("Johnson");
    	lastnames.add("Jones");
    	lastnames.add("Williams");
    	lastnames.add("Davis");
    	lastnames.add("Brown");
    	lastnames.add("Miller");
    	lastnames.add("Morningstar");
    	lastnames.add("Wilson");
    	lastnames.add("Moore");
    	lastnames.add("Taylor");
    	lastnames.add("Thomas");
    	lastnames.add("White");
    	lastnames.add("Anderson");
    	lastnames.add("Harris");
    	lastnames.add("Martin");
    	lastnames.add("Thompson");
    	lastnames.add("Martin");
    	lastnames.add("Hill");
    	lastnames.add("Lopez");
    	lastnames.add("Young");
    	lastnames.add("Stewart");
    	lastnames.add("Barnes");
    	lastnames.add("Ross");
    	lastnames.add("Price");
    	lastnames.add("Hughes");
    	lastnames.add("Butler");
    	lastnames.add("Torres");
    	lastnames.add("Howard");
    	lastnames.add("Cox");
    	lastnames.add("Carter");
    	lastnames.add("Perez");
    	lastnames.add("Flores");
    	lastnames.add("Coleman");
    	lastnames.add("Simmons");
    	lastnames.add("Patterson");
    	lastnames.add("Long");
    	lastnames.add("Simmons");
    	lastnames.add("Bryant");
    	lastnames.add("Watson");
    	lastnames.add("Lewis");
    	lastnames.add("Russel");
    	lastnames.add("Griffin");
    	lastnames.add("Foster");
    	lastnames.add("Evans");
    	lastnames.add("Turner");
    	lastnames.add("Diaz");
    	lastnames.add("Sanders");
    	lastnames.add("Collins");
    	lastnames.add("Toury");
    	lastnames.add("Lee");
    	lastnames.add("Walker");
    }
    
    public String getRandomName() {
    	String firstname = "";
    	String lastname = "";
    	firstname = firstnames.get(randor.nextInt(firstnames.size()));
    	lastname = lastnames.get(randor.nextInt(lastnames.size()));
    	String fullname = firstname + " " + lastname;
    	return fullname;
    }
    
	@EventHandler
	public void onPlayerJoinName(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(worlds.contains(p.getWorld().getName()) && namesE) {
		if(!usernames.containsKey(p.getName())) {
			addName(p.getName(), getRandomName());
		}
		p.setPlayerListName(usernames.get(p.getName()));
		}
	}

    public void addName(String name, String newname) {
    	usernames.put(name, newname);
    	saveNames();
    }
    
    public void getName(String what){
    	if(what == null) {
    		return;
    	}
    	String[] split = what.split(",");
    	if(split.length < 2) {
    		return;
    	}
    	String name = split[0];
    	String username = split[1].replace("_", " ");
    	usernames.put(name, username);
    }
	
    public void saveNames() {
    	List<String> full = new ArrayList<String>();
    	HashMap<String, String> namesCopy = new HashMap<String, String>(usernames);
    	for(String name : namesCopy.keySet()) {
    		String complete = name + "," + namesCopy.get(name).replace(" ", "_");
    		full.add(complete);
    	}
    	config.set("names", full);
    	saveConfig();
    }
    
    ///////////////////////////////////////////////////
    
    //Player NPCs
    
    public boolean inSpawnRegion(Location l) {
    	if(spawndistance < 2) {
    		return false;
    	}
    	Location spawn = l.getWorld().getSpawnLocation();
    	if(worlds.contains(l.getWorld().getName())) {
    	if((spawn.getX()+spawndistance>l.getX())&&(spawn.getX()-spawndistance<l.getX())) {
    		if((spawn.getZ()+spawndistance>l.getZ())&&(spawn.getZ()-spawndistance<l.getZ())) {
    	    		return true;
    	    }
    	}
    	return false;
    	}
    	return false;
    }
    
    public void addFake(String name, String uuid) {
    	playerFakes.put(name, uuid);
    	saveFakes();
    }
    
    public void getFake(String what){
    	if(what == null) {
    		return;
    	}
    	String[] split = what.split(",");
    	if(split.length < 2) {
    		return;
    	}
    	String name = split[0];
    	String uuid = split[1];
    	playerFakes.put(name, uuid);
    }
	
    public void saveFakes() {
    	List<String> full = new ArrayList<String>();
    	HashMap<String, String> fakesCopy = new HashMap<String, String>(playerFakes);
    	for(String fake : fakesCopy.keySet()) {
    		String complete = fake + "," + fakesCopy.get(fake);
    		full.add(complete);
    	}
    	config.set("fakes", full);
    	saveConfig();
    }
    
    @EventHandler
    public void fakePlayerDie(EntityDeathEvent e) {
    	if(worlds.contains(e.getEntity().getWorld().getName()) && npcE) {
    	if(e.getEntity() instanceof Husk) {
    		Husk h = (Husk) e.getEntity();
    		if(h.hasMetadata("player")) {
    		e.getDrops().clear();
    		EntityEquipment eq = h.getEquipment();
    		if(eq.getChestplate() != null) {
    			if(eq.getChestplate().getType() != Material.AIR) {
    			h.getWorld().dropItemNaturally(h.getLocation(), eq.getChestplate());
    			}
    		}
    		if(eq.getLeggings() != null) {
    			if(eq.getLeggings().getType() != Material.AIR) {
    			h.getWorld().dropItemNaturally(h.getLocation(), eq.getLeggings());
    			}
    		}
    		if(eq.getBoots() != null) {
    			if(eq.getBoots().getType() != Material.AIR) {
    			h.getWorld().dropItemNaturally(h.getLocation(), eq.getBoots());
    			}
    		}
    		if(eq.getItemInMainHand() != null) {
    			if(eq.getItemInMainHand().getType() != Material.AIR) {
    			h.getWorld().dropItemNaturally(h.getLocation(), eq.getItemInMainHand());
    			}
    		}
    		if(eq.getItemInOffHand() != null) {
    			if(eq.getItemInOffHand().getType() != Material.AIR) {
    			h.getWorld().dropItemNaturally(h.getLocation(), eq.getItemInOffHand());
    			}
    		}
    		}
    	}
    	}
    }
    
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
    	if(isNotWorld(e.getPlayer())) {
			return;
		}
    	if(worlds.contains(e.getPlayer().getWorld().getName()) && npcE) {
    	if(limboE) {
    	if(limbo.contains(e.getPlayer().getName())) {
    		return;
    	}
    	}
    	Player p = e.getPlayer();
    	if(inSpawnRegion(p.getLocation())) {
    		return;
    	}
    	Husk playerFake = (Husk) p.getWorld().spawnEntity(p.getLocation(), EntityType.HUSK);
    	playerFake.setSilent(true);
    	EntityEquipment eq = playerFake.getEquipment();
    	eq.setBoots(e.getPlayer().getInventory().getBoots());
    	eq.setBootsDropChance(100);
    	eq.setChestplate(e.getPlayer().getInventory().getChestplate());
    	eq.setChestplateDropChance(100);
    	eq.setItemInMainHand(e.getPlayer().getInventory().getItemInMainHand());
    	eq.setItemInMainHandDropChance(100);
    	eq.setItemInOffHand(e.getPlayer().getInventory().getItemInOffHand());
    	eq.setItemInOffHandDropChance(100);
    	ItemStack myAwesomeSkull = new ItemStack(Material.PLAYER_HEAD, 1);
		SkullMeta myAwesomeSkullMeta = (SkullMeta) myAwesomeSkull.getItemMeta();
		myAwesomeSkullMeta.setOwner("" + e.getPlayer().getName());
		myAwesomeSkull.setItemMeta(myAwesomeSkullMeta);
    	eq.setHelmet(myAwesomeSkull);
    	eq.setHelmetDropChance(100);
    	eq.setLeggings(e.getPlayer().getInventory().getLeggings());
    	eq.setLeggingsDropChance(100);
    	playerFake.setMetadata("player", new FixedMetadataValue(this, 0));
    	playerFake.setCanPickupItems(false);
    	playerFake.setRemoveWhenFarAway(false);
    	playerFake.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
    	addPotionEffectBetter(playerFake, PotionEffectType.SLOW, 999999, 100, false, false, false);
    	playerFake.setBaby(false);
    	for(PotionEffect pt : p.getActivePotionEffects()) {
    		playerFake.addPotionEffect(pt);
    	}
    	PlayerDisguise disguise = null;
    	if(nametagE) {
    		disguise = new PlayerDisguise(p.getName());
    	}
    	else if(npcE) {
    		disguise = new PlayerDisguise((p.getName().substring(0, p.getName().length()-1) + "~"));
    		disguise.getWatcher().setSkin(p.getName() + "");
    	}
        DisguiseAPI.disguiseEntity(playerFake, disguise);
    	String UUID = playerFake.getUniqueId().toString();
    	addFake(p.getName(), UUID);
    	}
    }
    
    @EventHandler
    public void onPlayerJoinUUID(PlayerJoinEvent e) {
    	Player p = e.getPlayer();
    	if(worlds.contains(e.getPlayer().getWorld().getName()) && npcE) {
    	Bukkit.getScheduler().runTaskLater(this, () -> doChecker(p), 1);
    	}
    }
    
    public void doChecker(Player p) {
    	if(limboE) {
    	if(limbo.contains(p.getName())) {
    		return;
    	}
    	}
    	if(playerFakes.containsKey(p.getName())) {
    		Entity player = Bukkit.getEntity(UUID.fromString(playerFakes.get(p.getName())));
    		if(player == null) {
    			Bukkit.getScheduler().runTaskLater(this, () -> killPlayer(p, null), 1);
    		}
    		else if(player.isDead()) {
    			Bukkit.getScheduler().runTaskLater(this, () -> killPlayer(p, ((Husk) player).getKiller()), 1);
    		}
    		else {
    			p.teleport(player.getLocation());
    			playerFakes.remove(p.getName());
    			player.remove();
    		}
    		playerFakes.remove(p.getName());
    		saveFakes();
    	}
    }
    
    public void killPlayer(Player p, Player killer) {
    	if(limboE) {
    	if(parkour.size()>0) {
    		if(parkour.get(0) != null) {
			if(parkour.get(0).size()>0) {
			if(p.getKiller() != null) {
				killer = p.getKiller();
				addKill(killer.getName(), 1);
			}
			addToLimbo(p.getName());
			int difficulty = kills.get(p.getName())/killsDivider;
			kills.put(p.getName(), 0);
			
			Bukkit.getScheduler().runTaskLater(this, () -> continuteLimbo(p, difficulty), 1);
			Bukkit.getScheduler().runTaskLater(this, () -> p.getInventory().clear(), 35);
			}
		}
    	}
    	}
    	else {
    		if(p.getBedSpawnLocation() != null) {
    			Bukkit.getScheduler().runTaskLater(this, () -> p.teleport(p.getBedSpawnLocation()), 2);
    		}
			else {
    			Bukkit.getScheduler().runTaskLater(this, () -> p.teleport(p.getWorld().getSpawnLocation()), 2);
			}
			Bukkit.getScheduler().runTaskLater(this, () -> p.sendMessage(ChatColor.RED + "You were killed while you were gone."), 35);
    		Bukkit.getScheduler().runTaskLater(this, () -> p.getInventory().clear(), 35);
    	}
    }
    
    @EventHandler
    public void entityTargetFake(EntityTargetEvent e) {
    	if(e.getTarget() instanceof Husk) {
    		if(e.getTarget().hasMetadata("player")) {
    			e.setCancelled(true);
    		}
    	}
    }
    
    ///////////////////////////////////////////////////
    
    //Longer Time - Inside of onEnable as a scheduler
    
    ///////////////////////////////////////////////////
    
    //Potions in Anvil
    
    @EventHandler
	public void playerShootBow(EntityShootBowEvent e) {
    	if(potionE) {
		if(e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			Projectile a = (Projectile) e.getProjectile();
			if(e.getBow().hasItemMeta()) {
				if(e.getBow().getItemMeta().hasLore()) {
					int count = 0;
					a.setMetadata("bowlore", new FixedMetadataValue(this, 0));
					for(String loreline : e.getBow().getItemMeta().getLore()) {
						if(loreline.charAt(loreline.length()-1) == 'I') {
							a.setMetadata(("potioneffect" + count), new FixedMetadataValue(this, loreline));
							count++;
						}
						if(count == 3) {
							break;
						}
					}
				}
			}
		}
    	}
    }
    
    @EventHandler
    public void onPlayerHitWithPotion(EntityDamageByEntityEvent e) {
    	if(potionE) {
    		if(inSpawnRegion(e.getEntity().getLocation())) {
				return;
			}
    	if(e.getDamager() instanceof Player && e.getEntity() instanceof LivingEntity) {
    		ItemStack item = ((Player) e.getDamager()).getInventory().getItemInMainHand();
			if(item != null) {
				if(item.getType() != Material.AIR) {
					if(item.hasItemMeta()) {
						if(item.getItemMeta().hasLore()) {
							doItemEffects(((LivingEntity) e.getEntity()), item.getItemMeta().getLore());
						}
					}
				}
			}
    	}
    	if(e.getDamager() instanceof Projectile && e.getEntity() instanceof LivingEntity) {
    		if(e.getDamager().hasMetadata("bowlore")) {
    				List<String> effects = new ArrayList<String>();
    				Entity a = e.getDamager();
    				if(a.hasMetadata("potioneffect0")) {
    					if(a.getMetadata("potioneffect0").size()>0) {
    						effects.add(a.getMetadata("potioneffect0").get(0).asString());
    					}
    				}
    				if(a.hasMetadata("potioneffect1")) {
    					if(a.getMetadata("potioneffect1").size()>0) {
    						effects.add(a.getMetadata("potioneffect1").get(0).asString());
    					}
    				}
    				if(a.hasMetadata("potioneffect2")) {
    					if(a.getMetadata("potioneffect2").size()>0) {
    						effects.add(a.getMetadata("potioneffect2").get(0).asString());
    					}
    				}
    				doItemEffects(((LivingEntity) e.getEntity()), effects);
    		}
    	}
    	}
    }
    
    public void doArmorEffects(Player p, List<String> lore) {
    	for(String effect : lore) {
    		if(effect.length()>0) {
    		if(effect.charAt(effect.length()-1) == 'I') {
    			String effectname = ChatColor.stripColor(effect.substring(0, effect.lastIndexOf(" ")));
    			String amplifier = ChatColor.stripColor(effect.substring(effect.lastIndexOf(" ")+1, effect.length()));
    			PotionEffectType pt = null;
    			int ampAmmount = 0;
    			if(amplifier.equals("II")) {
    				ampAmmount = 1;
    			}
    			if(effectname.equals("Haste")) {
    				pt = PotionEffectType.FAST_DIGGING;
    			}
    			else if(effectname.equals("Nausea")) {
    				pt = PotionEffectType.CONFUSION;
    			}
    			else if(effectname.equals("Mining Fatigue")) {
    				pt = PotionEffectType.SLOW_DIGGING;
    			}
    			else if(effectname.equals("Instant Damage")) {
    				pt = PotionEffectType.HARM;
    			}
    			else if(effectname.equals("Instant Health")) {
    				pt = PotionEffectType.HEAL;
    			}
    			else if(effectname.equals("Strength")) {
    				pt = PotionEffectType.INCREASE_DAMAGE;
    			}
    			else if(effectname.equals("Jump Boost")) {
    				pt = PotionEffectType.JUMP;
    			}
    			else if(effectname.equals("Slowness")) {
    				pt = PotionEffectType.SLOW;
    			}
    			else if(effectname.equals("Resistance")) {
    				pt = PotionEffectType.DAMAGE_RESISTANCE;
    			}
    			else {
    				pt = PotionEffectType.getByName((effectname.toUpperCase().replace(" ", "_")));
    			}
    			if(pt != null) {
    				if(pt == PotionEffectType.HEAL) {
    					if(randor.nextInt(20)==0) {
    						addPotionEffectBetter(p, pt, 20, ampAmmount, false, false, false);
    					}
    				}
    				else if(pt.getName().equals("NIGHT_VISION")) {
    					addPotionEffectBetter(p, pt, 20*16, ampAmmount, false, false, false);
    				}
    				else {
    					addPotionEffectBetter(p, pt, 20*5, ampAmmount, false, false, false);
    				}
    			}
    		}
    		}
    	}
    }
    
    public void addPotionEffectsArmor() {
    	for(Player p : Bukkit.getOnlinePlayers()) {
    		if(potionE) {
    		ItemStack[] armor = p.getInventory().getArmorContents();
    		for(int count = 0; count < armor.length; count++) {
    			ItemStack armorpiece = armor[count];
    			if(armorpiece != null) {
    				if(armorpiece.getType() != Material.AIR) {
    					if(armorpiece.hasItemMeta()) {
    						if(armorpiece.getItemMeta().hasLore()) {
    							doArmorEffects(p, armorpiece.getItemMeta().getLore());
    						}
    					}
    				}
    			}
    		}
    		}
    	}
    }
    
    public void doItemEffects(LivingEntity p, List<String> lore) {
    	for(String effect : lore) {
    		if(effect.charAt(effect.length()-1) == 'I') {
    			String effectname = ChatColor.stripColor(effect.substring(0, effect.lastIndexOf(" ")));
    			String amplifier = ChatColor.stripColor(effect.substring(effect.lastIndexOf(" ")+1, effect.length()));
    			PotionEffectType pt = null;
    			int ampAmmount = 0;
    			if(amplifier.equals("II")) {
    				ampAmmount = 1;
    			}
    			if(effectname.equals("Haste")) {
    				pt = PotionEffectType.FAST_DIGGING;
    			}
    			else if(effectname.equals("Nausea")) {
    				pt = PotionEffectType.CONFUSION;
    			}
    			else if(effectname.equals("Mining Fatigue")) {
    				pt = PotionEffectType.SLOW_DIGGING;
    			}
    			else if(effectname.equals("Instant Damage")) {
    				pt = PotionEffectType.HARM;
    			}
    			else if(effectname.equals("Instant Health")) {
    				pt = PotionEffectType.HEAL;
    			}
    			else if(effectname.equals("Strength")) {
    				pt = PotionEffectType.INCREASE_DAMAGE;
    			}
    			else if(effectname.equals("Jump Boost")) {
    				pt = PotionEffectType.JUMP;
    			}
    			else if(effectname.equals("Slowness")) {
    				pt = PotionEffectType.SLOW;
    			}
    			else if(effectname.equals("Resistance")) {
    				pt = PotionEffectType.DAMAGE_RESISTANCE;
    			}
    			else {
    				pt = PotionEffectType.getByName((effectname.toUpperCase().replace(" ", "_")));
    			}
    			if(pt != null) {
    				if(pt == PotionEffectType.HARM || pt == PotionEffectType.HEAL) {
    					addPotionEffectBetter(p, pt, 20, ampAmmount, false, false, false);
    				}
    				else {
    					addPotionEffectBetter(p, pt, (15*20), ampAmmount, false, false, false);
    				}
    			}
    		}
    	}
    }
    
    @EventHandler
    public void onAnvilPotion(PrepareAnvilEvent event) {
    	if(worlds.contains(event.getInventory().getLocation().getWorld().getName()) && potionE) {
		boolean doPotion = false;
		ItemStack item = null;
		ItemStack potion = null;
		for(ItemStack i : event.getInventory().getContents()) {
			if(i!=null) {
				Material m = i.getType();
			if(m.name().toLowerCase().contains("potion")) {
				doPotion=true;
				potion = i;
			}
			else {
				item = i;
			}
			}
		}
		if(doPotion==false||item==null) {
			return;
		}
		else {
			ItemStack newItem = item.clone();
			ItemMeta im = newItem.getItemMeta();
			List<String> lore = new ArrayList<String>();
			String effect = getPotionEnchantment(potion);
			if(effect.equals(ChatColor.GRAY + "")) {
				return;
			}
			if(im.hasLore()) {
				lore = im.getLore();
				if(lore.size() > 2) {
					return;
				}
				lore.add("" + getPotionEnchantment(potion));
				im.setLore(lore);
			}
			else {
				lore.add("" + getPotionEnchantment(potion));
				im.setLore(lore);
			}
			newItem.setItemMeta(im);
			//event.getInventory().setRepairCost(25);
			event.setResult(newItem);
			Bukkit.getScheduler().runTaskLater(this, () -> event.getInventory().setRepairCost(25), 1);
		}
    	}
	}
    
    public String getPotionEnchantment(ItemStack i) {
    	String name = ChatColor.GRAY + "";
    	PotionMeta pm = ((PotionMeta) i.getItemMeta());
    	if(pm.hasCustomEffects()) {
    		if(pm.hasCustomEffect(PotionEffectType.WITHER)) {
    			int amp = pm.getCustomEffects().get(0).getAmplifier();
    			if(amp == 0 || amp == 1) {
    				if(amp == 0) {
    					name += "Wither I";
    				}
    				else {
    					name += "Wither II";
    				}
    			}
    		}
    		else if(pm.hasCustomEffect(PotionEffectType.FAST_DIGGING)) {
    			int amp = pm.getCustomEffects().get(0).getAmplifier();
    			if(amp == 0 || amp == 1) {
    				if(amp == 0) {
    					name += "Haste I";
    				}
    				else {
    					name += "Haste II";
    				}
    			}
    		}
    		else if(pm.hasCustomEffect(PotionEffectType.DAMAGE_RESISTANCE)) {
    			int amp = pm.getCustomEffects().get(0).getAmplifier();
    			if(amp == 0 || amp == 1) {
    				if(amp == 0) {
    					name += "Resistance I";
    				}
    				else {
    					name += "Resistance II";
    				}
    			}
    		}
    		else if(pm.hasCustomEffect(PotionEffectType.CONFUSION)) {
    			int amp = pm.getCustomEffects().get(0).getAmplifier();
    			if(amp == 0 || amp == 1) {
    				if(amp == 0) {
    					name += "Nausea I";
    				}
    				else {
    					name += "Nausea II";
    				}
    			}
    		}
    		else if(pm.hasCustomEffect(PotionEffectType.BLINDNESS)) {
    			int amp = pm.getCustomEffects().get(0).getAmplifier();
    			if(amp == 0 || amp == 1) {
    				if(amp == 0) {
    					name += "Blindness I";
    				}
    				else {
    					name += "Blindness II";
    				}
    			}
    		}
    		else if(pm.hasCustomEffect(PotionEffectType.DAMAGE_RESISTANCE)) {
    			int amp = pm.getCustomEffects().get(0).getAmplifier();
    			if(amp == 0 || amp == 1) {
    				if(amp == 0) {
    					name += "Resistance I";
    				}
    				else {
    					name += "Resistance II";
    				}
    			}
    		}
    		else if(pm.hasCustomEffect(PotionEffectType.HUNGER)) {
    			int amp = pm.getCustomEffects().get(0).getAmplifier();
    			if(amp == 0 || amp == 1) {
    				if(amp == 0) {
    					name += "Hunger I";
    				}
    				else {
    					name += "Hunger II";
    				}
    			}
    		}
    		else if(pm.hasCustomEffect(PotionEffectType.HEALTH_BOOST)) {
    			int amp = pm.getCustomEffects().get(0).getAmplifier();
    			if(amp == 0 || amp == 1) {
    				if(amp == 0) {
    					name += "Health Boost I";
    				}
    				else {
    					name += "Health Boost II";
    				}
    			}
    		}
    		else if(pm.hasCustomEffect(PotionEffectType.SATURATION)) {
    			int amp = pm.getCustomEffects().get(0).getAmplifier();
    			if(amp == 0 || amp == 1) {
    				if(amp == 0) {
    					name += "Saturation I";
    				}
    				else {
    					name += "Saturation II";
    				}
    			}
    		}
    		else if(pm.hasCustomEffect(PotionEffectType.SLOW_DIGGING)) {
    			int amp = pm.getCustomEffects().get(0).getAmplifier();
    			if(amp == 0 || amp == 1) {
    				if(amp == 0) {
    					name += "Mining Fatigue I";
    				}
    				else {
    					name += "Mining Fatigue II";
    				}
    			}
    		}
    	}
    	else {
    		PotionEffectType pt = pm.getBasePotionData().getType().getEffectType();
    		boolean upgraded = pm.getBasePotionData().isUpgraded();
    		if(pt == PotionEffectType.FIRE_RESISTANCE) {
    			name += "Fire Resistance";
    		}
    		else if(pt == PotionEffectType.HARM) {
    			name += "Instant Damage";
    		}
    		else if(pt == PotionEffectType.HEAL) {
    			name += "Instant Health";
    		}
    		else if(pt == PotionEffectType.INCREASE_DAMAGE) {
    			name += "Strength";
    		}
    		else if(pt == PotionEffectType.INVISIBILITY) {
    			name += "Invisibility";
    		}
    		else if(pt == PotionEffectType.JUMP) {
    			name += "Jump Boost";
    		}
    		else if(pt == PotionEffectType.LEVITATION) {
    			name += "Levitation";
    		}
    		else if(pt == PotionEffectType.LUCK) {
    			name += "Luck";
    		}
    		else if(pt == PotionEffectType.NIGHT_VISION) {
    			name += "Night Vision";
    		}
    		else if(pt == PotionEffectType.POISON) {
    			name += "Poison";
    		}
    		else if(pt == PotionEffectType.REGENERATION) {
    			name += "Regeneration";
    		}
    		else if(pt == PotionEffectType.SLOW) {
    			name += "Slowness";
    		}
    		else if(pt == PotionEffectType.SLOW_FALLING) {
    			name += "Slow Falling";
    		}
    		else if(pt == PotionEffectType.SPEED) {
    			name += "Speed";
    		}
    		else if(pt == PotionEffectType.WATER_BREATHING) {
    			name += "Water Breathing";
    		}
    		else if(pt == PotionEffectType.WEAKNESS) {
    			name += "Weakness";
    		}
    		if(upgraded == false) {
    			name += " I";
    		}
    		else {
    			name += " II";
    		}
    	}
    	return name;
    }
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerClickInAnvilPotion(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if(worlds.contains(p.getWorld().getName()) && colorE) {
		if(e.getClickedInventory()!=null && p.getLevel()>=25) {
			if(e.getClickedInventory().getType()==InventoryType.ANVIL) {
				if(e.getSlot() == 2) {
				ItemStack one = e.getClickedInventory().getItem(0);
				ItemStack two = e.getClickedInventory().getItem(1);
				if(two == null || one == null) {
					return;
				}
				else {
					int potioncount = 0;
					if(two.getType().name().toLowerCase().contains("potion")) {
						potioncount++;
					}
					if(one.getType().name().toLowerCase().contains("potion")) {
						potioncount++;
					}
					if(potioncount == 1) {
						if(e.getCursor()==null) {
							e.setCursor(e.getClickedInventory().getItem(2));
						}
						else if(e.getCursor().getType() == Material.AIR) {
							e.setCursor(e.getClickedInventory().getItem(2));
						}
						else {
							p.getInventory().addItem(e.getClickedInventory().getItem(2));
						}
						e.getClickedInventory().setItem(0, new ItemStack(Material.AIR));
						e.getClickedInventory().setItem(1, new ItemStack(Material.AIR));
						e.getClickedInventory().setItem(2, new ItemStack(Material.AIR));
						p.setLevel(p.getLevel()-25);
						p.getWorld().playSound(p.getLocation(), Sound.ENTITY_GENERIC_SPLASH, 1, 1);
					}
					else {
						return;
					}
				}
				}
			}
		}
		}
	}
    
    ///////////////////////////////////////////////////
	
	//No Join or Leave Messages
	
	@EventHandler
	public void onPlayerLeaveGame(PlayerQuitEvent e) {
		if(worlds.contains(e.getPlayer().getWorld().getName()) && leaveE) {
		e.setQuitMessage(null);
		}
	}
	
	@EventHandler
	public void onPlayerJoinGame(PlayerJoinEvent e) {
		if(worlds.contains(e.getPlayer().getWorld().getName()) && joinE) {
		e.setJoinMessage(null);
		}
		if(!shopGUIS.enabled.containsKey(e.getPlayer().getName())) {
			shopGUIS.enabled.put(e.getPlayer().getName(), new ArrayList<Integer>());
		}
	}
	
	/////////////////////////////////////////////////// - RPG STYLE THINGS BELOW
	
	//Artifacts
	
	public void artifactInsideEffect() {
		List<String> players = new ArrayList<String>(playersInArtifact);
		for(String p : players) {
			Player player = Bukkit.getPlayer(p);
			if(player != null) {
				if(player.isOnline()) {
					addPotionEffectBetter(player, PotionEffectType.BLINDNESS, 13, 100, false, false, false);
				}
			}
		}
	}
	
	public boolean isNetherWorld(Location l) {
		World w = l.getWorld();
		String name = w.getName().toLowerCase();
		if(name.contains("nether")) {
			return true;
		}
		return false;
	}
	
	public ItemStack createArtifact() {
		ItemStack i = null;
		int choice = randor.nextInt(5);
		if(choice == 0) {
			i = new ItemStack(Material.EMERALD, 1);
		}
		else if(choice == 1) {
			i = new ItemStack(Material.FIRE_CHARGE, 1);
		}
		else if(choice == 2) {
			i = new ItemStack(Material.CYAN_DYE, 1);
		}
		else if(choice == 3) {
			i = new ItemStack(Material.MAGMA_CREAM, 1);
		}
		else if(choice == 4) {
			i = new ItemStack(Material.POPPED_CHORUS_FRUIT, 1);
		}
		ItemMeta im = i.getItemMeta();
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.BLACK + "Nether Artifact");
		if(choice == 0) {
			im.setDisplayName("§2Nether Artifact");
		}
		else if(choice == 1) {
			im.setDisplayName("§8Nether Artifact");
		}
		else if(choice == 2) {
			im.setDisplayName("§3Nether Artifact");
		}
		else if(choice == 3) {
			im.setDisplayName("§6Nether Artifact");
		}
		else if(choice == 4) {
			im.setDisplayName("§5Nether Artifact");
		}
		im.setLore(lore);
		i.setItemMeta(im);
		return i;
	}
	
	@EventHandler
	public void netherMobDeathEvent(EntityDeathEvent e) {
		if(artifactsE && isNetherWorld(e.getEntity().getLocation())) {
			if(e.getEntity() instanceof Monster) {
			if(randor.nextInt(100) == 0) {
				ItemStack artifact = createArtifact();
				e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), artifact);
			}
			}
		}
	}
	
	@EventHandler
	public void playerClickArtifact(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(artifactsE) {
		if(e.getAction() == Action.RIGHT_CLICK_AIR) {
			if(playersInArtifact.contains(p.getName())) {
				return;
			}
			ItemStack item = p.getInventory().getItemInMainHand();
			if(item != null) {
				if(item.hasItemMeta()) {
					if(item.getItemMeta().hasDisplayName() && item.getItemMeta().hasLore()) {
						List<String> lore = item.getItemMeta().getLore();
						String name = item.getItemMeta().getDisplayName();
						boolean canDo = true;
						if(!lore.contains(ChatColor.BLACK + "Nether Artifact")) {
							canDo = false;
						}
						if(!ChatColor.stripColor(name).toLowerCase().equals("nether artifact")) {
							canDo = false;
						}
						if(canDo) {
							removeItemNaturally(p);
							doArtifactActivationEffect(p);
						}
					}
				}
			}
		}
		}
	}
	
	public void doArtifactActivationEffect(Player p) {
		playersInArtifact.add(p.getName());
		p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_DEATH, 3, 0);
		Location l = p.getLocation();
		int sizeOfSide = 7;
		Material blockused = Material.BLACK_CONCRETE;
		l.subtract(sizeOfSide, sizeOfSide, sizeOfSide);
		for(int x = 0; x < sizeOfSide*2; x++) {
			for(int y = 0; y < sizeOfSide*2; y++) {
				for(int z = 0; z < sizeOfSide*2; z++) {
					Location copy = l.clone().add(x, y, z);
					if((x == 0 || x == sizeOfSide*2-1)||(y == 0 || y == sizeOfSide*2-1)||(z == 0 || z == sizeOfSide*2-1)) {
						p.sendBlockChange(copy, blockused.createBlockData());
					}
					else {
						p.sendBlockChange(copy, Material.AIR.createBlockData());
					}
				}
			}
		}
		p.sendBlockChange(p.getLocation().subtract(0, 1, 0), blockused.createBlockData());
		p.sendTitle(ChatColor.DARK_RED +  "Do Y" + ChatColor.MAGIC + "o" + ChatColor.RESET + "" + ChatColor.DARK_RED + "U deSirE", "P" + ChatColor.MAGIC + "o" + ChatColor.RESET + "" + ChatColor.DARK_RED + "wER?", 10, 50, 10);
		Bukkit.getScheduler().runTaskLater(this, () -> p.sendTitle(ChatColor.DARK_RED +  "i Wil" + ChatColor.MAGIC + "l" + ChatColor.RESET + "" + ChatColor.DARK_RED + "GiVe It", "t" + ChatColor.MAGIC + "O" + ChatColor.RESET + "" + ChatColor.DARK_RED + "yOu.", 10, 60, 10), 90);
		Bukkit.getScheduler().runTaskLater(this, () -> p.sendTitle(ChatColor.DARK_RED +  "nOw " + ChatColor.MAGIC + "Wak" + ChatColor.RESET + "" + ChatColor.DARK_RED + "e " + ChatColor.MAGIC + "u" + ChatColor.RESET + "" + ChatColor.DARK_RED + "P", "", 10, 60, 10), 210);
		Bukkit.getScheduler().runTaskLater(this, () -> removePlayerInArtifact(p.getName()), 320);
	}
	
	public void removePlayerInArtifact(String s) {
		Player p = Bukkit.getPlayer(s);
		playersInArtifact.remove(s);
		Location l = p.getLocation();
		int sizeOfSide = 7;
		l.subtract(sizeOfSide, sizeOfSide, sizeOfSide);
		for(int x = 0; x < sizeOfSide*2; x++) {
			for(int y = 0; y < sizeOfSide*2; y++) {
				for(int z = 0; z < sizeOfSide*2; z++) {
					Location copy = l.clone().add(x, y, z);
					p.sendBlockChange(copy, copy.getBlock().getType().createBlockData());
				}
			}
		}
		p.getWorld().playSound(p.getLocation(), Sound.ENTITY_SKELETON_HORSE_DEATH, 2, 0);
		decideOnGift(p);
	}
	
	@EventHandler
	public void artifactMove(PlayerMoveEvent e) {
		if(playersInArtifact.contains(e.getPlayer().getName())) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void artifactHurt(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			String name = ((Player) e.getEntity()).getName();
			if(playersInArtifact.contains(name)) {
				e.setCancelled(true);
			}
		}
	}
	
	public static void removeItemNaturally(Player p) {
		ItemStack i = p.getInventory().getItemInMainHand();
		if(i != null) {
			if(i.getType() != Material.AIR) {
				if (i.getAmount() <= 1) {
					p.getInventory().getItemInMainHand().setAmount(0);
				} 
				else {
					p.getInventory().getItemInMainHand().setAmount(i.getAmount() - 1);
				}
			}
		}
	}
	
	public void decideOnGift(Player p) {
		if(randor.nextBoolean()) {
			ItemStack artifact = onPhysicalArtifact();
			p.getWorld().dropItemNaturally(p.getLocation(), artifact);
		}
		else {
			if(shopGUIS.enabled.containsKey(p.getName())) {
				int ability = randor.nextInt(218);
				shopGUIS.enabled.get(p.getName()).add(ability);
				enabledAbility(ability, p);
				saveConfigs();
			}
		}
	}
	
	public ItemStack onPhysicalArtifact() {
		ItemStack item = null;
		int choose = randor.nextInt(31);
		int i = randor.nextInt(3);
		if(choose == 0) {
			if (i == 0) {
				item = new ItemStack(Material.GOLDEN_SWORD);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("Artifact");
				itemmeta.setLore(Arrays.asList("pg1"));
				item.setItemMeta(itemmeta);
			}
			if (i == 1) {
				item = new ItemStack(Material.GOLDEN_SWORD);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("Artifact");
				itemmeta.setLore(Arrays.asList("pg1g6"));
				item.setItemMeta(itemmeta);
			}
			if (i == 2) {
				item = new ItemStack(Material.GOLDEN_SWORD);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("Artifact");
				itemmeta.setLore(Arrays.asList("n12I4woop"));
				item.setItemMeta(itemmeta);
			}
		}
		else if(choose == 1) {
			if (randor.nextInt(5) == 1) {
				item = new ItemStack(Material.FEATHER);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§fPulling Device");
				itemmeta.setLore(Arrays.asList("Pulling Device Level: 3"));
				itemmeta.addEnchant(Enchantment.LURE, 1, false);
				itemmeta.hasItemFlag(ItemFlag.HIDE_ENCHANTS);
				item.setItemMeta(itemmeta);
			} 
			else if (randor.nextInt(3) == 1) {
				item = new ItemStack(Material.FEATHER);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§fPulling Device");
				itemmeta.setLore(Arrays.asList("Pulling Device Level: 2"));
				itemmeta.addEnchant(Enchantment.LURE, 1, false);
				itemmeta.hasItemFlag(ItemFlag.HIDE_ENCHANTS);
				item.setItemMeta(itemmeta);
			} 
			else {
				item = new ItemStack(Material.FEATHER);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§fPulling Device");
				itemmeta.setLore(Arrays.asList("Pulling Device Level: 1"));
				itemmeta.addEnchant(Enchantment.LURE, 1, false);
				itemmeta.hasItemFlag(ItemFlag.HIDE_ENCHANTS);
				item.setItemMeta(itemmeta);
			}
		}
		else if(choose == 2) {
			if (randor.nextInt(5) == 1) {
				item = new ItemStack(Material.COBWEB);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§fExplosive Web");
				itemmeta.setLore(Arrays.asList("Explosive Web Level: 3"));
				item.setItemMeta(itemmeta);
			} 
			else if (randor.nextInt(3) == 1) {
					item = new ItemStack(Material.COBWEB);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§fExplosive Web");
					itemmeta.setLore(Arrays.asList("Explosive Web Level: 2"));
					item.setItemMeta(itemmeta);
			} 
			else {
					item = new ItemStack(Material.COBWEB);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§fExplosive Web");
					itemmeta.setLore(Arrays.asList("Explosive Web Level: 1"));
					item.setItemMeta(itemmeta);
				}
		}
		else if(choose == 3) {
			item = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta itemM = (LeatherArmorMeta) item.getItemMeta();
			itemM.setColor(Color.fromRGB(0, 0, 0));
			itemM.setDisplayName("§0Boots of Beserk");
			itemM.setLore(Arrays.asList("Hide in the Dark but Die in the Light"));
			item.setItemMeta(itemM);
		}
		else if(choose == 4) {
			if (randor.nextInt(5) == 1) {
				item = new ItemStack(Material.GRAY_DYE);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Special Egg");
				itemmeta.setLore(Arrays.asList("Special Egg Level: 3"));
				item.setItemMeta(itemmeta);
			} 
			else if (randor.nextInt(3) == 1) {
					item = new ItemStack(Material.GRAY_DYE);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§7Special Egg");
					itemmeta.setLore(Arrays.asList("Special Egg Level: 2"));
					item.setItemMeta(itemmeta);
			} 
			else {
						item = new ItemStack(Material.GRAY_DYE);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§7Special Egg");
						itemmeta.setLore(Arrays.asList("Special Egg Level: 1"));
						item.setItemMeta(itemmeta);
			}
		}
		else if(choose == 5) {
			if (randor.nextInt(5) == 1) {
				item = new ItemStack(Material.SUGAR);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§9Nyoom");
				itemmeta.setLore(Arrays.asList("Nyoom Level: 3"));
				item.setItemMeta(itemmeta);
			} 
			else if (randor.nextInt(3) == 1) {
					item = new ItemStack(Material.SUGAR);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§9Nyoom");
					itemmeta.setLore(Arrays.asList("Nyoom Level: 2"));
					item.setItemMeta(itemmeta);
			} 
			else {
						item = new ItemStack(Material.SUGAR);
						ItemMeta itemmeta = item.getItemMeta();
						itemmeta.setDisplayName("§9Nyoom");
						itemmeta.setLore(Arrays.asList("Nyoom Level: 1"));
						item.setItemMeta(itemmeta);
				}
		}
		else if(choose == 6) {
			item = new ItemStack(Material.COAL);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§0Really Sharp Dust");
			itemmeta.setLore(Arrays.asList("Really Sharp Dust"));
			item.setItemMeta(itemmeta);
		}
		else if(choose == 7) {
			if (randor.nextInt(5) == 1) {
				item = new ItemStack(Material.FLINT);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§0Wither Talisman");
				itemmeta.setLore(Arrays.asList("Wither Talisman Level: 3"));
				item.setItemMeta(itemmeta);
			} else if (randor.nextInt(3) == 1) {
				item = new ItemStack(Material.FLINT);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§0Wither Talisman");
				itemmeta.setLore(Arrays.asList("Wither Talisman Level: 2"));
				item.setItemMeta(itemmeta);
				} else {
					item = new ItemStack(Material.FLINT);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§0Wither Talisman");
					itemmeta.setLore(Arrays.asList("Wither Talisman Level: 1"));
					item.setItemMeta(itemmeta);
				}
		}
		else if(choose == 8) {
			if (randor.nextInt(5) == 1) {
				item = new ItemStack(Material.LIME_DYE);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§aTheif Talisman");
				itemmeta.setLore(Arrays.asList("Theif Talisman Level: 2"));
				item.setItemMeta(itemmeta);
			} else{
				item = new ItemStack(Material.LIME_DYE);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§aTheif Talisman");
				itemmeta.setLore(Arrays.asList("Theif Talisman Level: 1"));
				item.setItemMeta(itemmeta);
				}
		}
		else if(choose == 9) {
			item = new ItemStack(Material.SAND);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§eQuicksand Talisman");
			itemmeta.setLore(Arrays.asList("Quicksand Talisman"));
			item.setItemMeta(itemmeta);
		}
		else if(choose == 10) {
			int choice = randor.nextInt(10);
			if(choice==0) {
				item = new ItemStack(Material.COOKED_PORKCHOP);
			}
			else if(choice==1) {
				item = new ItemStack(Material.PORKCHOP);
			}
			else if(choice==2) {
				item = new ItemStack(Material.COOKED_BEEF);						
			}
			else if(choice==3) {
				item = new ItemStack(Material.BEEF);
			}
			else if(choice==4) {
				item = new ItemStack(Material.CHICKEN);
			}
			else if(choice==5) {
				item = new ItemStack(Material.COOKED_COD);
			}
			else if(choice==6) {
				item = new ItemStack(Material.COOKED_CHICKEN);
			}
			else if(choice==7) {
				item = new ItemStack(Material.COD);
			}
			else if(choice==8) {
				item = new ItemStack(Material.COOKED_MUTTON);
			}
			else if(choice==9) {
				item = new ItemStack(Material.COOKED_RABBIT);
			}
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§cHearty Food");
			itemmeta.setLore(Arrays.asList("Hearty Food"));
			item.setItemMeta(itemmeta);
		}
		else if(choose == 11) {
			item = new ItemStack(Material.RED_DYE);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§cLifesteal Talisman");
			itemmeta.setLore(Arrays.asList("Lifesteal Talisman"));
			item.setItemMeta(itemmeta);
		}
		else if(choose == 12) {
			item = new ItemStack(Material.SPLASH_POTION);
			PotionMeta potionMeta = (PotionMeta) item.getItemMeta();
			potionMeta.setColor(Color.YELLOW);
			potionMeta.setDisplayName("§eLightning Bottle");
			potionMeta.setLore(Arrays.asList("Lightning Bottle"));
			potionMeta.addEnchant(Enchantment.LURE, 1, false);
			potionMeta.hasItemFlag(ItemFlag.HIDE_ENCHANTS);
			item.setItemMeta(potionMeta);
		}
		else if(choose == 13) {
			if (randor.nextInt(5) == 1) {
				item = new ItemStack(Material.FERMENTED_SPIDER_EYE);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§4Eye of Weakness");
				itemmeta.setLore(Arrays.asList("Eye of Weakness Level: 3"));
				item.setItemMeta(itemmeta);
			} 
			else if (randor.nextInt(3) == 1) {
				item = new ItemStack(Material.FERMENTED_SPIDER_EYE);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§4Eye of Weakness");
				itemmeta.setLore(Arrays.asList("Eye of Weakness Level: 2"));
				item.setItemMeta(itemmeta);
				} 
			else {
					item = new ItemStack(Material.FERMENTED_SPIDER_EYE);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§4Eye of Weakness");
					itemmeta.setLore(Arrays.asList("Eye of Weakness Level: 1"));
					item.setItemMeta(itemmeta);
					
				}
		}
		else if(choose == 14) {
			if (randor.nextInt(5) == 1) {
				item = new ItemStack(Material.FIRE_CHARGE);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§6Molten Core");
				itemmeta.setLore(Arrays.asList("Molten Core Level: 3"));
				item.setItemMeta(itemmeta);
			} else if (randor.nextInt(3) == 1) {
				item = new ItemStack(Material.FIRE_CHARGE);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§6Molten Core");
				itemmeta.setLore(Arrays.asList("Molten Core Level: 2"));
				item.setItemMeta(itemmeta);
				} else {
					item = new ItemStack(Material.FIRE_CHARGE);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§6Molten Core");
					itemmeta.setLore(Arrays.asList("Molten Core Level: 1"));
					item.setItemMeta(itemmeta);
					
				}
		}
		else if(choose == 15) {
			item = new ItemStack(Material.PRISMARINE_SHARD);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§3Gravity Anomaly");
			itemmeta.setLore(Arrays.asList("Gravity Anomaly"));
			item.setItemMeta(itemmeta);
		}
		else if(choose == 16) {
			item = new ItemStack(Material.ROTTEN_FLESH);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§8Spoiled Food");
			itemmeta.setLore(Arrays.asList("Spoiled Food"));
			item.setItemMeta(itemmeta);
		}
		else if(choose == 17) {
			if (randor.nextInt(5) == 1) {
				item = new ItemStack(Material.FIRE_CHARGE);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§6Compressed Fireball");
				itemmeta.setLore(Arrays.asList("Compressed Fireball Level: 3"));
				itemmeta.addEnchant(Enchantment.LURE, 1, false);
				itemmeta.hasItemFlag(ItemFlag.HIDE_ENCHANTS);
				item.setItemMeta(itemmeta);
			} 
			else if (randor.nextInt(3) == 1) {
				item = new ItemStack(Material.FIRE_CHARGE);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§6Compressed Fireball");
				itemmeta.setLore(Arrays.asList("Compressed Fireball Level: 2"));
				itemmeta.addEnchant(Enchantment.LURE, 1, false);
				itemmeta.hasItemFlag(ItemFlag.HIDE_ENCHANTS);
				item.setItemMeta(itemmeta);
				} 
			else {
					item = new ItemStack(Material.FIRE_CHARGE);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§6Compressed Fireball");
					itemmeta.setLore(Arrays.asList("Compressed Fireball Level: 1"));
					itemmeta.addEnchant(Enchantment.LURE, 1, false);
					itemmeta.hasItemFlag(ItemFlag.HIDE_ENCHANTS);
					item.setItemMeta(itemmeta);
					
			}
		}
		else if(choose == 18) {
			if (randor.nextInt(5) == 1) {
				item = new ItemStack(Material.BOW);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Assault Bow");
				itemmeta.setLore(Arrays.asList("Assault Bow Level: 3"));
				item.setItemMeta(itemmeta);
			} else if (randor.nextInt(3) == 1) {
				item = new ItemStack(Material.BOW);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Assault Bow");
				itemmeta.setLore(Arrays.asList("Assault Bow Level: 2"));
				item.setItemMeta(itemmeta);
				} else {
					item = new ItemStack(Material.BOW);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§7Assault Bow");
					itemmeta.setLore(Arrays.asList("Assault Bow Level: 1"));
					item.setItemMeta(itemmeta);
				}
		}
		else if(choose == 19) {
			if (randor.nextInt(5) == 1) {
				item = new ItemStack(Material.GOLDEN_AXE);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§0Anogoth");
				itemmeta.setLore(Arrays.asList("Anogoth Level: 3"));
				item.setItemMeta(itemmeta);
			} else if (randor.nextInt(3) == 1) {
				item = new ItemStack(Material.GOLDEN_AXE);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§0Anogoth");
				itemmeta.setLore(Arrays.asList("Anogoth Level: 2"));
				item.setItemMeta(itemmeta);
				} else {
					item = new ItemStack(Material.GOLDEN_AXE);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§0Anogoth");
					itemmeta.setLore(Arrays.asList("Anogoth Level: 1"));
					item.setItemMeta(itemmeta);
				}
		}
		else if(choose == 20) {
			if (randor.nextInt(5) == 1) {
				item = new ItemStack(Material.IRON_CHESTPLATE);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Nano-Tech Armor");
				itemmeta.setLore(Arrays.asList("Nano-Tech Armor Level: 3"));
				item.setItemMeta(itemmeta);
			} else if (randor.nextInt(3) == 1) {
				item = new ItemStack(Material.IRON_CHESTPLATE);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setDisplayName("§7Nano-Tech Armor");
				itemmeta.setLore(Arrays.asList("Nano-Tech Armor Level: 2"));
				item.setItemMeta(itemmeta);
				} else {
					item = new ItemStack(Material.IRON_CHESTPLATE);
					ItemMeta itemmeta = item.getItemMeta();
					itemmeta.setDisplayName("§7Nano-Tech Armor");
					itemmeta.setLore(Arrays.asList("Nano-Tech Armor Level: 1"));
					item.setItemMeta(itemmeta);
					
				}
		}
		else if(choose == 21) {
			item = new ItemStack(Material.GHAST_TEAR);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§0Goddess Tear");
			itemmeta.setLore(Arrays.asList("Goddess Tear"));
			itemmeta.addEnchant(Enchantment.LURE, 1, false);
			itemmeta.hasItemFlag(ItemFlag.HIDE_ENCHANTS);
			item.setItemMeta(itemmeta);
		}
		else if(choose == 22) {
			item = new ItemStack(Material.GOLD_NUGGET);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6Beserk Tear");
			itemmeta.setLore(Arrays.asList("Beserk Tear"));
			itemmeta.addEnchant(Enchantment.LURE, 1, false);
			itemmeta.hasItemFlag(ItemFlag.HIDE_ENCHANTS);
			item.setItemMeta(itemmeta);
		}
		else if(choose == 23) {
			item = new ItemStack(Material.IRON_NUGGET);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§7Screamer Talisman");
			itemmeta.setLore(Arrays.asList("Screamer Talisman"));
			itemmeta.addEnchant(Enchantment.LURE, 1, false);
			itemmeta.hasItemFlag(ItemFlag.HIDE_ENCHANTS);
			item.setItemMeta(itemmeta);
		}
		else if(choose == 24) {
			item = new ItemStack(Material.PLAYER_HEAD, 1 , (short) 3);
			SkullMeta itemmeta = (SkullMeta) item.getItemMeta();
			itemmeta.setOwner("colin");
			itemmeta.setDisplayName("§4Watcher Head");
			itemmeta.setLore(Arrays.asList("Watcher Head"));
			item.setItemMeta(itemmeta);
		}
				
		else if(choose == 25) {
			item = new ItemStack(Material.FIRE_CHARGE);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§6DIY Fireball");
			itemmeta.setLore(Arrays.asList("DIY Fireball"));
			item.setItemMeta(itemmeta);
		}
		else if(choose == 26) {
			item = new ItemStack(Material.POTION);
			PotionMeta itemmeta = (PotionMeta) item.getItemMeta();
			itemmeta.setColor(Color.BLACK);
			itemmeta.setDisplayName("§0Keeper's Blood");
			itemmeta.setLore(Arrays.asList("Keeper's Blood"));
			itemmeta.addCustomEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 2400, 29), true);
			itemmeta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 2400, 6), true);
			itemmeta.addCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 2400, 6), true);
			itemmeta.addCustomEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 2400, 3), true);
			itemmeta.addCustomEffect(new PotionEffect(PotionEffectType.LUCK, 2400, 3), true);
			itemmeta.addCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 2400, 1), true);
			item.setItemMeta(itemmeta);
		}
		else if(choose == 27) {
			item = new ItemStack(Material.LINGERING_POTION);
			PotionMeta itemmeta = (PotionMeta) item.getItemMeta();
			itemmeta.setColor(Color.WHITE);
			itemmeta.setDisplayName("§fShadow Dust");
			itemmeta.setLore(Arrays.asList("Shadow Dust"));
			itemmeta.addCustomEffect(new PotionEffect(PotionEffectType.WITHER, 400, 4), true);
			itemmeta.addCustomEffect(new PotionEffect(PotionEffectType.BLINDNESS, 400, 6), true);
			itemmeta.addCustomEffect(new PotionEffect(PotionEffectType.HUNGER, 400, 7), true);
			itemmeta.addCustomEffect(new PotionEffect(PotionEffectType.SLOW, 100, 200), true);
			itemmeta.addCustomEffect(new PotionEffect(PotionEffectType.CONFUSION, 400, 200), true);
			item.setItemMeta(itemmeta);
		}
		else if(choose == 28) {
			item = new ItemStack(Material.FLINT_AND_STEEL);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§eFlint and Thermite");
			itemmeta.setLore(Arrays.asList("Flint and Thermite"));
			item.setItemMeta(itemmeta);
		}
		else if(choose == 29) {
			item = new ItemStack(Material.PINK_DYE);
			ItemMeta itemmeta = item.getItemMeta();
			itemmeta.setDisplayName("§dCute Egg");
			itemmeta.setLore(Arrays.asList("Cute Egg"));
			item.setItemMeta(itemmeta);
		}
		else if(choose == 30) {
			item = new ItemStack(Material.LEATHER_HELMET);
			LeatherArmorMeta itemM = (LeatherArmorMeta) item.getItemMeta();
			itemM.setColor(Color.fromRGB(58, 34, 7));
			itemM.setDisplayName("§8Linear Device");
			itemM.setLore(Arrays.asList("Linear Device"));
			item.setItemMeta(itemM);
		}
		return item;
	}
	
	public static void removeItemNaturallyA(Player p, int i) {
		if (p.getInventory().getItem(i).getAmount() <= 1) {
			p.getInventory().getItem(i).setAmount(0);
		} else {
			p.getInventory().getItem(i).setAmount(p.getInventory().getItem(i).getAmount() - 1);
		}
	}
	
	public boolean hasLore(Player p, String word) {
		boolean hasLore = false;
		if(p != null) {
			if(p.getInventory().getItemInMainHand() != null) {
				ItemStack i = p.getInventory().getItemInMainHand();
				if(i != null) {
				if(i.hasItemMeta()) {
					if(i.getItemMeta().hasLore()) {
						List<String> lore = i.getItemMeta().getLore();
						if(lore.size()>0) {
							if(lore.contains(ChatColor.stripColor(word))) {
								hasLore = true;
							}
						}
					} 
				}
				}
			}
		}
		return hasLore;
	}
	
	public boolean hasLore(ItemStack i, String word) {
		boolean hasLore = false;
			if(i != null) {
				if(i.hasItemMeta()) {
					if(i.getItemMeta().hasLore()) {
						List<String> lore = i.getItemMeta().getLore();
						if(lore.size()>0) {
							if(lore.contains(ChatColor.stripColor(word))) {
								hasLore = true;
							}
						}
					} 
				}
			}
		return hasLore;
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	@EventHandler
	public void artifactClick(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		if(inSpawnRegion(p.getLocation())) {
			return;
		}
		if(event.getAction()==Action.RIGHT_CLICK_BLOCK||event.getAction()==Action.RIGHT_CLICK_AIR) {
			if(hasLore(p, "Pulling Device Level: 3")) {
					for(Entity e : p.getNearbyEntities(12, 12, 12)) {
							e.setVelocity(p.getLocation().toVector().subtract(e.getLocation().toVector()).normalize().multiply(5));
					}
				removeItemNaturally(p);
				return;
			}
						else if(hasLore(p, "Pulling Device Level: 2")) {
							for(Entity e : p.getNearbyEntities(7, 7, 7)) {
								e.setVelocity(p.getLocation().toVector()
										.subtract(e.getLocation().toVector()).normalize().multiply(3));
							}
							removeItemNaturally(p);
							return;
						}
						else if(hasLore(p, "Pulling Device Level: 1")) {
							for(Entity e : p.getNearbyEntities(5, 5, 5)) {
								e.setVelocity(p.getLocation().toVector()
										.subtract(e.getLocation().toVector()).normalize().multiply(2));
							}
							removeItemNaturally(p);
							return;
						}
						//Spawner 1/2
						if(event.getAction()==Action.RIGHT_CLICK_BLOCK) {
						if(hasLore(p, "Special Egg Level: 3")) {
							LivingEntity e1 = (LivingEntity) p.getWorld().spawnEntity(event.getClickedBlock().getLocation().add(0, 1, 0), EntityType.SILVERFISH);
							e1.setMetadata(p.getName(), new FixedMetadataValue(this, 0));
							LivingEntity e2 = (LivingEntity) p.getWorld().spawnEntity(event.getClickedBlock().getLocation().add(0, 1, 0), EntityType.SILVERFISH);
							e2.setMetadata(p.getName(), new FixedMetadataValue(this, 0));
							LivingEntity e3 = (LivingEntity) p.getWorld().spawnEntity(event.getClickedBlock().getLocation().add(0, 1, 0), EntityType.SILVERFISH);
							e3.setMetadata(p.getName(), new FixedMetadataValue(this, 0));
							removeItemNaturally(p);
							return;
						}
						else if(hasLore(p, "Special Egg Level: 2")) {
							LivingEntity e1 = (LivingEntity) p.getWorld().spawnEntity(event.getClickedBlock().getLocation().add(0, 1, 0), EntityType.SILVERFISH);
							e1.setMetadata(p.getName(), new FixedMetadataValue(this, 0));
							LivingEntity e2 = (LivingEntity) p.getWorld().spawnEntity(event.getClickedBlock().getLocation().add(0, 1, 0), EntityType.SILVERFISH);
							e2.setMetadata(p.getName(), new FixedMetadataValue(this, 0));
							removeItemNaturally(p);
							return;
						}
						else if(hasLore(p, "Special Egg Level: 1")) {
							LivingEntity e1 = (LivingEntity) p.getWorld().spawnEntity(event.getClickedBlock().getLocation().add(0, 1, 0), EntityType.SILVERFISH);
							e1.setMetadata(p.getName(), new FixedMetadataValue(this, 0));
							removeItemNaturally(p);
							return;
						}
						if(hasLore(p, "Gravity Anomaly")) {
							for(Entity e : p.getNearbyEntities(7, 7, 7)) {
								if(e instanceof LivingEntity) {
									((LivingEntity) e).addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 800, 10));
								}
							}
							p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 800, 10));
							removeItemNaturally(p);
							return;
						}
						}
						if(event.getAction()==Action.RIGHT_CLICK_AIR) {
							if(hasLore(p, "Beserk Tear")) {
								p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 240, 10));
								removeItemNaturally(p);
								return;
							}
					}
		}
		if(event.getAction()==Action.LEFT_CLICK_AIR||event.getAction()==Action.LEFT_CLICK_BLOCK) {
			if(hasLore(p, "Nyoom Level: 3")) {
							List<Entity> ents = p.getNearbyEntities(7, 7, 7);
							Entity e = null;
							if(!ents.isEmpty()) {
								e = ents.get(0);
								e.setVelocity(new Vector(0,3,0));
							}
							removeItemNaturally(p);
							return;
						}
						else if(hasLore(p, "Nyoom Level: 2")) {
							List<Entity> ents = p.getNearbyEntities(7, 7, 7);
							Entity e = null;
							if(!ents.isEmpty()) {
								e = ents.get(0);
								e.setVelocity(new Vector(0,2,0));
							}
							removeItemNaturally(p);
							return;
						}
						else if(hasLore(p, "Nyoom Level: 1")) {
							List<Entity> ents = p.getNearbyEntities(7, 7, 7);
							Entity e = null;
							if(!ents.isEmpty()) {
								e = ents.get(0);
								e.setVelocity(new Vector(0,1,0));
							}
							removeItemNaturally(p);
							return;
						}
						if(event.getAction()==Action.LEFT_CLICK_BLOCK) {
							if(hasLore(p, "DIY Fireball")) {
								Location l = event.getClickedBlock().getLocation().add(0, 1.4, 0);
								p.getWorld().spawnEntity(l, EntityType.FIREBALL);
								removeItemNaturally(p);
								return;
							}
						}
						if(hasLore(p, "Flint and Thermite")) {
							List<Entity> ents = p.getNearbyEntities(9, 9, 9);
							Player e = null;
							if(!ents.isEmpty()) {
								for(Entity es : ents) {
									if(es instanceof Player) {
										e = (Player) es;
										int radius = 3;
										Location loc = e.getLocation();
						    			int cx = loc.getBlockX();
						    			int cy = loc.getBlockY();
						    			int cz = loc.getBlockZ();
						    			for (int x = cx - radius; x <= cx + radius; x++) {
						    				for (int z = cz - radius; z <= cz + radius; z++) {
						    					for (int y = (cy - radius); y < (cy + radius); y++) {
						    						double dist = (cx - x) * (cx - x) + (cz - z) * (cz - z) + ((cy - y) * (cy - y));

						    						if (dist < radius * radius) {
						    							Location l = new Location(loc.getWorld(), x, y, z);
						    							if(isAir(l.getBlock().getType())) {
						    								l.getBlock().setType(Material.FIRE, false);
						    							}
						    						}
						    					}
						    				}
						    			}
										break;
									}
								}
							}
							int radius = 2;
							Location loc = p.getLocation();
			    			int cx = loc.getBlockX();
			    			int cy = loc.getBlockY();
			    			int cz = loc.getBlockZ();
			    			for (int x = cx - radius; x <= cx + radius; x++) {
			    				for (int z = cz - radius; z <= cz + radius; z++) {
			    					for (int y = (cy - radius); y < (cy + radius); y++) {
			    						double dist = (cx - x) * (cx - x) + (cz - z) * (cz - z) + ((cy - y) * (cy - y));

			    						if (dist < radius * radius) {
			    							Location l = new Location(loc.getWorld(), x, y, z);
			    							if(isAir(l.getBlock().getType())) {
			    								l.getBlock().setType(Material.FIRE, false);
			    							}
			    						}
			    					}
			    				}
			    			}
							removeItemNaturally(p);
							return;
						}
						if(event.getAction()==Action.LEFT_CLICK_AIR) {
							if(hasLore(p, "Really Sharp Dust")) {
								List<Entity> ents = p.getNearbyEntities(7, 7, 7);
								Player e = null;
								if(!ents.isEmpty()) {
									for(Entity es : ents) {
										if(es instanceof Player) {
											e = (Player) es;
											e.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 400, 10));
											break;
										}
									}
								}
								removeItemNaturally(p);
								return;
							}
							if(hasLore(p, "Compressed Fireball Level: 3")) {
								Location l = p.getLocation();
								p.launchProjectile(SmallFireball.class, l.getDirection());
								Bukkit.getScheduler().runTaskLater(this, () -> p.launchProjectile(SmallFireball.class, l.getDirection()), 3);
								Bukkit.getScheduler().runTaskLater(this, () -> p.launchProjectile(SmallFireball.class, l.getDirection()), 6);
								Bukkit.getScheduler().runTaskLater(this, () -> p.launchProjectile(SmallFireball.class, l.getDirection()), 9);
								Bukkit.getScheduler().runTaskLater(this, () -> p.launchProjectile(SmallFireball.class, l.getDirection()), 12);
								Bukkit.getScheduler().runTaskLater(this, () -> p.launchProjectile(SmallFireball.class, l.getDirection()), 15);
								Bukkit.getScheduler().runTaskLater(this, () -> p.launchProjectile(SmallFireball.class, l.getDirection()), 18);
								Bukkit.getScheduler().runTaskLater(this, () -> p.launchProjectile(SmallFireball.class, l.getDirection()), 21);
								removeItemNaturally(p);
								return;
							}
							else if(hasLore(p, "Compressed Fireball Level: 2")) {
								Location l = p.getLocation();
								p.launchProjectile(SmallFireball.class, l.getDirection());
								Bukkit.getScheduler().runTaskLater(this, () -> p.launchProjectile(SmallFireball.class, l.getDirection()), 3);
								Bukkit.getScheduler().runTaskLater(this, () -> p.launchProjectile(SmallFireball.class, l.getDirection()), 6);
								Bukkit.getScheduler().runTaskLater(this, () -> p.launchProjectile(SmallFireball.class, l.getDirection()), 9);
								removeItemNaturally(p);
								return;
							}
							else if(hasLore(p, "Compressed Fireball Level: 1")) {
								Location l = p.getLocation();
								p.launchProjectile(SmallFireball.class, l.getDirection());
								Bukkit.getScheduler().runTaskLater(this, () -> p.launchProjectile(SmallFireball.class, l.getDirection()), 3);
								removeItemNaturally(p);
								return;
				}
			}
		}
	}
	
	@EventHandler
	public void artifactTargeting(EntityTargetEvent event) {
		if(event.getEntityType()==EntityType.SILVERFISH||event.getEntityType()==EntityType.CAVE_SPIDER||event.getEntityType()==EntityType.SPIDER) {
			if(event.getTarget() instanceof Player) {
				if(event.getEntity().hasMetadata(((Player) event.getTarget()).getName())) {
					event.setCancelled(true);
				}
			}
		}
		else {
			return;
		}
	}
	
	public static Location getBlockBehindPlayerE(Entity player) {
		Vector inverseDirectionVec = player.getLocation().getDirection().normalize().multiply(-1);
		return player.getLocation().add(inverseDirectionVec);
	}
	
	@EventHandler
	public void onPlayerDmg(EntityDamageByEntityEvent event) {
		if(event.getDamager() instanceof LivingEntity && event.getEntity() instanceof Player) {
			PlayerInventory i = ((Player) event.getEntity()).getInventory();
			if(inSpawnRegion(event.getEntity().getLocation()) || event.isCancelled()) {
				return;
			}
			if(i.contains(Material.PINK_DYE)||i.contains(Material.IRON_NUGGET)||i.contains(Material.GHAST_TEAR)||i.contains(Material.PLAYER_HEAD)||i.getHelmet()!=null) {
				Player p = ((Player) event.getEntity());
				for(ItemStack it : i.getContents()) {
					
							if(hasLore(it, "Watcher Head")) {
								if(randor.nextInt(5)==1) {
								p.teleport(getBlockBehindPlayerE(event.getDamager()));
								removeItemNaturallyA(p, i.first(it));
								}
							}
							if(hasLore(it, "Goddess Tear")) {
								if(randor.nextInt(3)==1) {
								p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 40, 2));
								}
							}
							if(hasLore(it, "Cute Egg")) {
								if(randor.nextInt(21)==1) {
									LivingEntity e1 = (LivingEntity) p.getWorld().spawnEntity(p.getLocation().add(0, 1, 0), EntityType.CAVE_SPIDER);
									e1.setMetadata(p.getName(), new FixedMetadataValue(this, 0));
									LivingEntity e2 = (LivingEntity) p.getWorld().spawnEntity(p.getLocation().add(0, 1, 0), EntityType.SPIDER);
									e2.setMetadata(p.getName(), new FixedMetadataValue(this, 0));
								}
							}
							if(hasLore(it, "Screamer Talisman")) {
								if(randor.nextInt(3)==1) {
									if(event.getDamager() instanceof Player) {
										int randomC = randor.nextInt(9);
										Player p2 = (Player) event.getDamager();
										if(randomC==0) {
											p2.playSound(p2.getLocation(), Sound.AMBIENT_CAVE, 1, 0);
										}
										if(randomC==1) {
											p2.playSound(p2.getLocation(), Sound.AMBIENT_CAVE, 1, 1);
										}
										if(randomC==2) {
											p2.playSound(p2.getLocation(), Sound.AMBIENT_CAVE, 1, 2);
										}
										if(randomC==3) {
											p2.playSound(p2.getLocation(), Sound.ENTITY_SKELETON_HORSE_DEATH, 1, 0);
										}
										if(randomC==4) {
											p2.playSound(p2.getLocation(), Sound.ENTITY_SKELETON_HORSE_DEATH, 1, 1);
										}
										if(randomC==5) {
											p2.playSound(p2.getLocation(), Sound.ENTITY_SKELETON_HORSE_DEATH, 1, 2);
										}
										if(randomC==6) {
											p2.playSound(p2.getLocation(), Sound.ENTITY_MULE_DEATH, 1, 0);
										}
										if(randomC==7) {
											p2.playSound(p2.getLocation(), Sound.ENTITY_MULE_DEATH, 1, 1);
										}
										if(randomC==8) {
											p2.playSound(p2.getLocation(), Sound.ENTITY_MULE_DEATH, 1, 2);
										}
										
									}
									
								}
							}
				}
								if(hasLore(i.getHelmet(), "Linear Device")) {
									for(PotionEffect po : p.getActivePotionEffects()) {
										p.removePotionEffect(po.getType());
									}
									double damage = event.getFinalDamage();
									p.damage(damage);
								}
			}
		}
		if(event.getDamager() instanceof Player && event.getEntity() instanceof LivingEntity) {
			PlayerInventory i = ((Player) event.getDamager()).getInventory();
			Player p = ((Player) event.getDamager());
			if(i.contains(Material.RED_DYE)||i.contains(Material.LIME_DYE)||i.contains(Material.FIRE_CHARGE)||i.contains(Material.SAND)||i.contains(Material.FLINT)) {
				for(ItemStack it : i.getContents()) {
							if(hasLore(it, "Quicksand Talisman")) {
								if(randor.nextInt(6)==1) {
									((LivingEntity) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 140, 1));
									event.getEntity().getLocation().subtract(0, 1, 0).getBlock().setType(Material.SAND);
								}
							}
							if(hasLore(it, "Lifesteal Talisman")) {
								if(randor.nextInt(4)==1) {
									p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 200));
								}
							}
							if(hasLore(it, "Wither Talisman Level: 3")) {
									((LivingEntity) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 60, 3));
							}
							if(hasLore(it, "Wither Talisman Level: 2")) {
								((LivingEntity) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 60, 2));
							}
							if(hasLore(it, "Wither Talisman Level: 1")) {
								((LivingEntity) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 60, 1));
							}
							if(hasLore(it, "Molten Core Level: 3")) {
								((LivingEntity) event.getEntity()).setFireTicks(140);
								if(randor.nextInt(2)==1) {
									((LivingEntity) event.getEntity()).getLocation().getBlock().setType(Material.FIRE);
								}
								if(randor.nextInt(100)==1) {
									((LivingEntity) event.getEntity()).getLocation().getBlock().setType(Material.LAVA);
								}
							}
							if(hasLore(it, "Molten Core Level: 2")) {
								((LivingEntity) event.getEntity()).setFireTicks(70);
								if(randor.nextInt(4)==1) {
									((LivingEntity) event.getEntity()).getLocation().getBlock().setType(Material.FIRE);
								}
								if(randor.nextInt(200)==1) {
									((LivingEntity) event.getEntity()).getLocation().getBlock().setType(Material.LAVA);
								}
							}
							if(hasLore(it, "Molten Core Level: 1")) {
								((LivingEntity) event.getEntity()).setFireTicks(40);
								if(randor.nextInt(8)==1) {
									((LivingEntity) event.getEntity()).getLocation().getBlock().setType(Material.FIRE);
								}
								if(randor.nextInt(300)==1) {
									((LivingEntity) event.getEntity()).getLocation().getBlock().setType(Material.LAVA);
								}
							}
							if(hasLore(it, "Theif Talisman Level: 2")) {
								if(randor.nextInt(20)==1) {
									if(event.getEntity() instanceof Player) {
										Player p2 = (Player) event.getEntity();
										if(p2.getInventory().getItemInMainHand()!=null) {
											p2.getWorld().dropItemNaturally(p2.getLocation(), p2.getInventory().getItemInMainHand());
											p2.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
										}
									}
								}
							}
						}
					}
				
								if(hasLore(i.getHelmet(), "Linear Device")) {
									int dr = 0;
									int id = 0;
									if(p.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) {
										dr = p.getPotionEffect(PotionEffectType.DAMAGE_RESISTANCE).getAmplifier() + 1;
										p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
									}
									if(p.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
										id = p.getPotionEffect(PotionEffectType.INCREASE_DAMAGE).getAmplifier() + 1;
										p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
									}
									p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1200, dr));
									p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1200, id));
								}
					
		}
		
	}
	
	public void doWeb(Location le, int rad) {
		int radius = rad;
		Location loc = le;
		int cx = loc.getBlockX();
		int cy = loc.getBlockY();
		int cz = loc.getBlockZ();
		for (int x = cx - radius; x <= cx + radius; x++) {
			for (int z = cz - radius; z <= cz + radius; z++) {
				for (int y = (cy - radius); y < (cy + radius); y++) {
					double dist = (cx - x) * (cx - x) + (cz - z) * (cz - z) + ((cy - y) * (cy - y));

					if (dist < radius * radius) {
						Location l = new Location(loc.getWorld(), x, y, z);
						if(l.getBlock().getType()==Material.AIR) {
							l.getBlock().setType(Material.COBWEB, false);
						}
					}
				}
			}
		}
		le.getWorld().spawnParticle(Particle.SMOKE_LARGE, le,
				200);
	}
	
	@EventHandler
	public void onArtifactPlaced(BlockPlaceEvent event) {
		ItemStack it = event.getItemInHand();
		Player p = ((Player) event.getPlayer());
		if(inSpawnRegion(p.getLocation()) || event.isCancelled()) {
			return;
		}
				if(hasLore(it, "Explosive Web Level: 3")) {
					if(p.getInventory().getItemInMainHand()!=null) {
						if(p.getInventory().getItemInMainHand().getAmount()>=1) {
							removeItemNaturally(p);
						}
					}
					Bukkit.getScheduler().runTaskLater(this, () -> doWeb(event.getBlock().getLocation(), 4), 120);
					return;
				}
				else if(hasLore(it, "Explosive Web Level: 2")) {
					if(p.getInventory().getItemInMainHand()!=null) {
						if(p.getInventory().getItemInMainHand().getAmount()>=1) {
							removeItemNaturally(p);
						}
					}
					Bukkit.getScheduler().runTaskLater(this, () -> doWeb(event.getBlock().getLocation(), 3), 120);
					return;
				}
				else if(hasLore(it, "Explosive Web Level: 1")) {
					if(p.getInventory().getItemInMainHand()!=null) {
						if(p.getInventory().getItemInMainHand().getAmount()>=1) {
							removeItemNaturally(p);
						}
					}
					Bukkit.getScheduler().runTaskLater(this, () -> doWeb(event.getBlock().getLocation(), 2), 120);
					return;
				}
	}
	
	@EventHandler
	public void onArtifactEat(PlayerItemConsumeEvent event) {
		ItemStack it = event.getItem();
		Player p = ((Player) event.getPlayer());
		if(inSpawnRegion(p.getLocation())) {
			return;
		}
				if(hasLore(it, "Hearty Food")) {
					p.setFoodLevel(20);
					return;
				}
				if(hasLore(it, "Demonic Meat")) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 500, 10, false, false), true);
					p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 500, 4, false, false), true);
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 500, 1, false, false), true);
					p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 500, 2, false, false), true);
					return;
				}
				if(hasLore(it, "Spoiled Food")) {
					int i = 1;
					if(randor.nextBoolean()==true) {
						i = -1;
					}
					int i2 = 1;
					if(randor.nextBoolean()==true) {
						i2 = -1;
					}
					final int iF = i;
					final int iF2 = i2;
					p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 240, 200));
					Bukkit.getScheduler().runTaskLater(this, () -> p.teleport(new Location(p.getWorld(), iF*randor.nextInt(20000),randor.nextInt(200)+1,iF2*randor.nextInt(20000))), 120);
					return;
				}
	}
	
	@EventHandler
	public void onArtifactShoot(EntityShootBowEvent event) {
		if(event.getEntity() instanceof Player) {
			ItemStack it = event.getBow();
			Player p = ((Player) event.getEntity());
			if(inSpawnRegion(p.getLocation())) {
				return;
			}
					Vector v = new Vector(event.getProjectile().getVelocity().getX(),event.getProjectile().getVelocity().getY(),event.getProjectile().getVelocity().getZ());
					if(hasLore(it, "Assault Bow Level: 3")) {
						Bukkit.getScheduler().runTaskLater(this, () -> p.launchProjectile(Arrow.class, v), 5);	
						Bukkit.getScheduler().runTaskLater(this, () -> p.launchProjectile(Arrow.class, v), 10);	
						Bukkit.getScheduler().runTaskLater(this, () -> p.launchProjectile(Arrow.class, v), 15);	
					}
					if(hasLore(it, "Assault Bow Level: 2")) {
						Bukkit.getScheduler().runTaskLater(this, () -> p.launchProjectile(Arrow.class, v), 5);	
						Bukkit.getScheduler().runTaskLater(this, () -> p.launchProjectile(Arrow.class, v), 10);		
					}
					if(hasLore(it, "Assault Bow Level: 1")) {
						Bukkit.getScheduler().runTaskLater(this, () -> p.launchProjectile(Arrow.class, v), 5);	
					}
			}
	}
	
	@EventHandler
	public void onMoveing(PlayerMoveEvent event) {
		Player p = event.getPlayer();
		if(inSpawnRegion(p.getLocation())) {
			return;
		}
		if(hasLore(p.getInventory().getBoots(), "Hide in the Dark but Die in the Light")) {
			if (p.isSneaking()) {
				if (new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ()).getBlock().getLightLevel() < 5) {
					addPotionEffectBetter(p, PotionEffectType.INVISIBILITY, 65, 1, false, false, false);
				} 
				else {
					p.sendMessage(ChatColor.DARK_RED + "The Light Consumed You!");
					p.damage(100000);
				}
			}
		}
	}
	
	@EventHandler
	public void onSplashArtifacct(PotionSplashEvent event) {
		ItemStack it = event.getPotion().getItem();
			if(hasLore(it, "Lightning Bottle")) {
				if(inSpawnRegion(event.getEntity().getLocation())) {
					return;
				}
				if(event.getHitBlock() != null) {
					event.getHitBlock().getWorld().strikeLightning(event.getHitBlock().getRelative(event.getHitBlockFace()).getLocation());
				}
				else if(event.getHitEntity() != null) {
					event.getHitEntity().getWorld().strikeLightning(event.getHitEntity().getLocation());
				}
				else if(event.getEntity() != null) {
					event.getEntity().getWorld().strikeLightning(event.getEntity().getLocation());
				}
			}
	}
	
	@EventHandler
	public void onArtifactSneak(PlayerToggleSneakEvent event) {
		PlayerInventory i = ((Player) event.getPlayer()).getInventory();
		if(inSpawnRegion(event.getPlayer().getLocation())) {
			return;
		}
		if(i.contains(Material.FERMENTED_SPIDER_EYE)) {
			for(ItemStack it : i.getContents()) {
						Player p = ((Player) event.getPlayer());
						if(hasLore(it, "Eye of Weakness Level: 3")) {
							for(Entity e : p.getNearbyEntities(10, 10, 10)) {
								if(e instanceof LivingEntity) {
									((LivingEntity) e).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 3600, 2));
								}
							}
							removeItemNaturallyA(p, i.first(it));
						}
						else if(hasLore(it, "Eye of Weakness Level: 2")) {
							for(Entity e : p.getNearbyEntities(8, 8, 8)) {
								if(e instanceof LivingEntity) {
									((LivingEntity) e).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 3600, 1));
								}
							}
							removeItemNaturallyA(p, i.first(it));
						}
						else if(hasLore(it, "Eye of Weakness Level: 1")) {
							for(Entity e : p.getNearbyEntities(6, 6, 6)) {
								if(e instanceof LivingEntity) {
									((LivingEntity) e).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 2400, 0));
								}
							}
							removeItemNaturallyA(p, i.first(it));
						}
				}
			}
		ItemStack its = event.getPlayer().getInventory().getItemInMainHand();
		
				Player p = ((Player) event.getPlayer());
				Location l = p.getLocation();
				if(hasLore(its, "Anogoth Level: 3")) {
					p.launchProjectile(WitherSkull.class, l.getDirection());
					Bukkit.getScheduler().runTaskLater(this, () -> p.launchProjectile(WitherSkull.class, l.getDirection()), 20);
					Bukkit.getScheduler().runTaskLater(this, () -> p.launchProjectile(WitherSkull.class, l.getDirection()), 40);
					p.damage(6);
				}
				else if(hasLore(its, "Anogoth Level: 2")) {
					p.launchProjectile(SmallFireball.class, l.getDirection());
					Bukkit.getScheduler().runTaskLater(this, () -> p.launchProjectile(WitherSkull.class, l.getDirection()), 20);
					p.damage(6);
				}
				else if(hasLore(its, "Anogoth Level: 1")) {
					p.launchProjectile(WitherSkull.class, l.getDirection());
					p.damage(6);
			}
		}
	
	@EventHandler
	public void onEntityDeath2(EntityDeathEvent event) {
		if(event.getEntity() instanceof LivingEntity) {
	     LivingEntity entity = event.getEntity();
	    if(entity.getKiller() != null) {
	         ItemStack its = ((Player) entity.getKiller()).getInventory().getChestplate();
	 				Player p = (Player) entity.getKiller();
	 				if(hasLore(its, "Nano-Tech Armor Level: 3")) {
	 					p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 2400, 4));
	 				}
	 				else if(hasLore(its, "Nano-Tech Armor Level: 2")) {
	 					p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 2400, 2));
	 				}
	 				else if(hasLore(its, "Nano-Tech Armor Level: 1")) {
	 					p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 2400, 1));
					}
	 			}
	 			
	 		}
	}
	
	///////////////////////////////////////////////////
	
	@EventHandler
	public void onEntityKillPlayer(EntityDamageByEntityEvent e) {
		if(artifactsE) {
		if(isNotWorld(e.getEntity())) {
			return;
		}
		if(e.isCancelled()) {
			return;
		}
		if(notnpc(e.getEntity()) && (!(e.getDamager() instanceof Player))) {
			Player p = (Player) e.getEntity();
			e.setDamage(runDamage(p, "final", e.getFinalDamage(), null));
		}
		}
	}
	
	@EventHandler
	public void onPlayerDeath(EntityDamageEvent e) {
		if(e.isCancelled()) {
			return;
		}
		if((notnpc(e.getEntity())) && ((e.getCause() != DamageCause.ENTITY_ATTACK) && (e.getCause() != DamageCause.ENTITY_SWEEP_ATTACK))) {
			Player p = (Player) e.getEntity();
		
			if(randor.nextInt(15)==1) {
				if(shopGUIS.enabled.get(p.getName()).contains(149)) {
					e.setCancelled(true);
					healPlayer(p, 200);
					feedPlayer(p, 200);
					p.getWorld().playSound(p.getLocation(), Sound.ITEM_TOTEM_USE, 1, 1);
					p.getWorld().spawnParticle(Particle.TOTEM, p.getLocation().add(0, 1, 0), 30, 0.4, 0.5, 0.4, 0.05);
					return;
				}
			}
			
			e.setDamage(runDamage(p, "final", e.getFinalDamage(), null));
		}
	}

    public int getInAirReach(Player p) {
    	int addition = 0;
    	Location l = p.getLocation();
    	if(isAir(l.clone().subtract(0, 1, 0).getBlock().getType())) {
    		addition++;
    		if(isAir(l.clone().subtract(0, 2, 0).getBlock().getType())) {
        		addition++;
        		if(isAir(l.clone().subtract(0, 3, 0).getBlock().getType())) {
            		addition++;
            	}
        	}
    	}
    	return addition;
    }
    
    public double getInAirScope(Player p) {
    	double addition = 0;
    	Location l = p.getLocation();
    	if(isAir(l.clone().subtract(0, 1, 0).getBlock().getType())) {
    		addition = addition + .08;
    		if(isAir(l.clone().subtract(0, 2, 0).getBlock().getType())) {
        		addition = addition + .08;
        		if(isAir(l.clone().subtract(0, 3, 0).getBlock().getType())) {
            		addition = addition + .08;
            	}
        	}
    	}
    	return addition;
    }
    
	//powers n' pvp
	
		@EventHandler
		public void onPlayerInteract2(PlayerInteractEvent e) {
			Player p = e.getPlayer();
			if(shopGUIS.enabled.get(e.getPlayer().getName()).contains(173)) {
				if(p.isSneaking()) {
				if(e.getAction()==Action.LEFT_CLICK_AIR) {
					attackPower.put(p.getName(), (float) (attackPower.get(p.getName()) + .0001));
				}
				if(e.getAction()==Action.LEFT_CLICK_AIR&&jumpcd.get(p.getName()).count==0&&(Math.abs(jumpcd.get(p.getName()).countS-System.currentTimeMillis())>=jumpcd.get(p.getName()).tempSec)) {
					int time = getTime(p.getInventory().getItemInMainHand(),p.getInventory());
					if(time==2) {
					jumpcd.get(p.getName()).addTime(getTime(p.getInventory().getItemInMainHand(),p.getInventory()), 0);
					countDown(p);
					if(isAir(p.getLocation().subtract(0, 1, 0).getBlock().getType())==false) {
						p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation(), 35, 0,0,0,0.05f, p.getLocation().subtract(0, 1, 0).getBlock().getType().createBlockData());
					}
					Vector direction = (p.getLocation().getDirection().multiply(.75)).multiply(1+(1.25*velocityPower.get(p.getName())));
					p.setVelocity(direction);
					p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 65, 0, false, false));
					velocityPower.put(p.getName(), (float) (velocityPower.get(p.getName()) + .0001));
					p.playSound(p.getLocation(), Sound.ENTITY_HORSE_BREATHE, 100, (float) 1.2);
					}
					else if(time==3) {
						if(velocityPower.get(p.getName())>.1) {
						jumpcd.get(p.getName()).addTime(getTime(p.getInventory().getItemInMainHand(),p.getInventory()), 1200);
						countDown(p);
						if(isAir(p.getLocation().subtract(0, 1, 0).getBlock().getType())==false) {
							p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation(), 45, 0,0,0,0.05f, p.getLocation().subtract(0, 1, 0).getBlock().getType().createBlockData());
						}
						Vector direction = (p.getLocation().getDirection().multiply(.75)).multiply(getPower(p.getInventory().getItemInMainHand(),p.getInventory())+(1.35*velocityPower.get(p.getName())));
						p.setVelocity(direction);
						p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 120, 0, false, false));
						velocityPower.put(p.getName(), (float) (velocityPower.get(p.getName()) + .0001));
						p.playSound(p.getLocation(), Sound.ENTITY_HORSE_BREATHE, 100, (float) 1.2);
						}
					}
					else if(time==4) {
						if(velocityPower.get(p.getName())>.3) {
						jumpcd.get(p.getName()).addTime(getTime(p.getInventory().getItemInMainHand(),p.getInventory()), 1600);
						countDown(p);
						if(isAir(p.getLocation().subtract(0, 1, 0).getBlock().getType())==false) {
							p.getWorld().spawnParticle(Particle.BLOCK_CRACK, p.getLocation(), 55, 0,0,0,0.05f, p.getLocation().subtract(0, 1, 0).getBlock().getType().createBlockData());
						}
						Vector direction = (p.getLocation().getDirection().multiply(.85)).multiply(getPower(p.getInventory().getItemInMainHand(),p.getInventory())+(1.45*velocityPower.get(p.getName())));
						p.setVelocity(direction);
						p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 165, 0, false, false));
						velocityPower.put(p.getName(), (float) (velocityPower.get(p.getName()) + .0001));
						p.playSound(p.getLocation(), Sound.ENTITY_HORSE_BREATHE, 100, (float) 1.2);
						}
					}
				}
			}
			if((e.getAction()==Action.RIGHT_CLICK_AIR||e.getAction()==Action.RIGHT_CLICK_BLOCK)) {
				if(blockBehindPlayer(p)==true) {
					Vector direction = (p.getLocation().getDirection().multiply(.1)).multiply(1+velocityPower.get(p.getName()));
					if(velocityPower.get(p.getName())>.05) {
					direction.setY(direction.getY()+.2);
					}
					p.setVelocity(direction);
					velocityPower.put(p.getName(), (float) (velocityPower.get(p.getName()) + .000001));
					p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 100, (float) 1.2);
				}
			}
		}
			if(shopGUIS.enabled.get(e.getPlayer().getName()).contains(178)||shopGUIS.enabled.get(e.getPlayer().getName()).contains(179)) {
			if((e.getAction()==Action.LEFT_CLICK_AIR||e.getAction()==Action.LEFT_CLICK_BLOCK)&&(getSword(p.getInventory().getItemInMainHand())!=Material.AIR)) {
				List<Entity> es = p.getNearbyEntities(3+reachPower.get(p.getName())+getInAirReach(p), 3+reachPower.get(p.getName())+getInAirReach(p), 3+reachPower.get(p.getName())+getInAirReach(p));
				for(Entity est : es) {
					if(est instanceof LivingEntity) {
						if(getLookingAt2(p, (LivingEntity) est)==true) {
							Material item = getSword(p.getInventory().getItemInMainHand());
							if(item==Material.WOODEN_SWORD) {
								if(est instanceof Player) {
									if(((4+attackPower.get(p.getName())+getstrengthincrease(p))-(resisPower.get(((Player) est).getName())))<=0){
										
									}
									else {
										damageReducer.ReducedDamage(((LivingEntity) est), (4+attackPower.get(p.getName())+getstrengthincrease(p))-(resisPower.get(((Player) est).getName())), p);
									}
								}
								else {
								((LivingEntity) est).damage(4+attackPower.get(p.getName())+getstrengthincrease(p), p);
								}
								runHitVelocity(est, p, strengthPower.get(p.getName()));
							}
							else if(item==Material.STONE_SWORD) {
								if(est instanceof Player) {
									if(((5+attackPower.get(p.getName())+getstrengthincrease(p))-(resisPower.get(((Player) est).getName())))<=0){
										
									}
									else {
										damageReducer.ReducedDamage(((LivingEntity) est), (5+attackPower.get(p.getName())+getstrengthincrease(p))-(resisPower.get(((Player) est).getName())), p);
									}
								}
								else {
								((LivingEntity) est).damage(5+attackPower.get(p.getName())+getstrengthincrease(p), p);
								}
								runHitVelocity(est, p, strengthPower.get(p.getName()));
							}
							else if(item==Material.IRON_SWORD) {
								if(est instanceof Player) {
									if(((6+attackPower.get(p.getName())+getstrengthincrease(p))-(resisPower.get(((Player) est).getName())))<=0){
										
									}
									else {
										damageReducer.ReducedDamage(((LivingEntity) est), (6+attackPower.get(p.getName())+getstrengthincrease(p))-(resisPower.get(((Player) est).getName())), p);
									}
								}
								else {
								((LivingEntity) est).damage(6+attackPower.get(p.getName())+getstrengthincrease(p), p);
								}
								runHitVelocity(est, p, strengthPower.get(p.getName()));
							}
							else if(item==Material.GOLDEN_SWORD) {
								if(est instanceof Player) {
									if(((4+attackPower.get(p.getName())+getstrengthincrease(p))-(resisPower.get(((Player) est).getName())))<=0){
										
									}
									else {
										damageReducer.ReducedDamage(((LivingEntity) est), (4+attackPower.get(p.getName())+getstrengthincrease(p))-(resisPower.get(((Player) est).getName())), p);
									}
								}
								else {
								((LivingEntity) est).damage(4+attackPower.get(p.getName())+getstrengthincrease(p), p);
								}
								runHitVelocity(est, p, strengthPower.get(p.getName()));
							}
							else if(item==Material.DIAMOND_SWORD) {
								if(est instanceof Player) {
									if(((7+attackPower.get(p.getName())+getstrengthincrease(p))-(resisPower.get(((Player) est).getName())))<=0){
										
									}
									else {
										damageReducer.ReducedDamage(((LivingEntity) est), (7+attackPower.get(p.getName())+getstrengthincrease(p))-(resisPower.get(((Player) est).getName())), p);
									}
								}
								else {
								((LivingEntity) est).damage(7+attackPower.get(p.getName())+getstrengthincrease(p), p);
								}
								runHitVelocity(est, p, strengthPower.get(p.getName()));
							}
							else if(item==Material.WOODEN_AXE) {
								if(est instanceof Player) {
									if(((2+attackPower.get(p.getName())+getstrengthincrease(p))-(resisPower.get(((Player) est).getName())))<=0){
										
									}
									else {
										damageReducer.ReducedDamage(((LivingEntity) est), (4+attackPower.get(p.getName())+getstrengthincrease(p))-(resisPower.get(((Player) est).getName())), p);
									}
								}
								else {
								((LivingEntity) est).damage(4+attackPower.get(p.getName())+getstrengthincrease(p), p);
								}
								runHitVelocity(est, p, strengthPower.get(p.getName()));
							}
							else if(item==Material.STONE_AXE) {
								if(est instanceof Player) {
									if(((3+attackPower.get(p.getName())+getstrengthincrease(p))-(resisPower.get(((Player) est).getName())))<=0){
										
									}
									else {
										damageReducer.ReducedDamage(((LivingEntity) est), (5+attackPower.get(p.getName())+getstrengthincrease(p))-(resisPower.get(((Player) est).getName())), p);
									}
								}
								else {
								((LivingEntity) est).damage(5+attackPower.get(p.getName())+getstrengthincrease(p), p);
								}
								runHitVelocity(est, p, strengthPower.get(p.getName()));
							}
							else if(item==Material.IRON_AXE) {
								if(est instanceof Player) {
									if(((4+attackPower.get(p.getName())+getstrengthincrease(p))-(resisPower.get(((Player) est).getName())))<=0){
										
									}
									else {
										damageReducer.ReducedDamage(((LivingEntity) est), (7+attackPower.get(p.getName())+getstrengthincrease(p))-(resisPower.get(((Player) est).getName())), p);
									}
								}
								else {
								((LivingEntity) est).damage(7+attackPower.get(p.getName())+getstrengthincrease(p), p);
								}
								runHitVelocity(est, p, strengthPower.get(p.getName()));
							}
							else if(item==Material.GOLDEN_AXE) {
								if(est instanceof Player) {
									if(((2+attackPower.get(p.getName())+getstrengthincrease(p))-(resisPower.get(((Player) est).getName())))<=0){
										
									}
									else {
										damageReducer.ReducedDamage(((LivingEntity) est), (6+attackPower.get(p.getName())+getstrengthincrease(p))-(resisPower.get(((Player) est).getName())), p);
									}
								}
								else {
								((LivingEntity) est).damage(6+attackPower.get(p.getName())+getstrengthincrease(p), p);
								}
								runHitVelocity(est, p, strengthPower.get(p.getName()));
							}
							else if(item==Material.DIAMOND_AXE) {
								if(est instanceof Player) {
									if(((6+attackPower.get(p.getName())+getstrengthincrease(p))-(resisPower.get(((Player) est).getName())))<=0){
										
									}
									else {
										damageReducer.ReducedDamage(((LivingEntity) est), (9+attackPower.get(p.getName())+getstrengthincrease(p))-(resisPower.get(((Player) est).getName())), p);
									}
								}
								else {
								((LivingEntity) est).damage(9+attackPower.get(p.getName())+getstrengthincrease(p), p);
								}
								runHitVelocity(est, p, strengthPower.get(p.getName()));
							}
						}
					}
					else {
						if(getLookingAt(p, est)==true) {
							Material item = getSword(p.getInventory().getItemInMainHand());
							if(item!=Material.AIR) {
								if((est instanceof Arrow)||(est instanceof Snowball)||(est instanceof Egg)||(est instanceof EnderPearl)||(est instanceof Fireball)) {
									if(est.hasMetadata(p.getName())) {
										
									}
									else {
									est.setVelocity(est.getVelocity().multiply(-1+(-1*velocityPower.get(p.getName()))));
									velocityPower.put(p.getName(), (float) (velocityPower.get(p.getName()) + .0002));
									}
								}
							}
						}
					}
				}
			}
			}
			
		}
		
		public int getstrengthincrease(Player p) {
			if(p.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
				int amp = p.getPotionEffect(PotionEffectType.INCREASE_DAMAGE).getAmplifier()+1;
				return 3 * amp;
			}
			return 0;
		}
		
		void sendPacket(Player p, Object packet) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException {
		    Object nmsPlayer = p.getClass().getMethod("getHandle").invoke(p);
		    Object plrConnection = nmsPlayer.getClass().getField("playerConnection").get(nmsPlayer);
		    plrConnection.getClass().getMethod("sendPacket", getNmsClass("Packet")).invoke(plrConnection, packet);
		}

		Class<?> getNmsClass(String nmsClassName) throws ClassNotFoundException {
		    return Class.forName("net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3] + "." + nmsClassName);
		}
		
		public void runHitVelocity(Entity e1, Entity e2, float strengthPower) {
			if(e1 instanceof ArmorStand) {
				if(((ArmorStand) e1).getCustomName()!=null) {
					return;
				}
			}
			if(e1 instanceof Player) {
				Player p = (Player) e1;
				if(shopGUIS.enabled.get(p.getName()).contains(32)) {
					return;
				}
				if(shopGUIS.enabled.get(p.getName()).contains(16)) {
				e1.setVelocity(e2.getLocation().toVector()
						.subtract(e1.getLocation().toVector()).normalize().multiply(-.5));
				return;
				}
			}
			e1.setVelocity(e2.getLocation().toVector()
					.subtract(e1.getLocation().toVector()).normalize().multiply(-1.1-(strengthPower/10.0)));
		}
		
		public void destroyArrow(Arrow a) {
			for(Player pa : Bukkit.getServer().getOnlinePlayers()) {
				try {
				Object packet = getNmsClass("PacketPlayOutEntityDestroy").getConstructor(int[].class).newInstance(new int[] {a.getEntityId()});
		        sendPacket(pa, packet);
				}
				catch (Exception e) {
			        e.printStackTrace();
			    }
			}
		}
		
		public boolean blockBehindPlayer(Player p) {
			Location l = p.getLocation();
			if(isAir(l.subtract(0, .08, 0).getBlock().getType())==false) {
				return false;
			}
			else {
				int direction = (Math.round(l.getYaw()/90))+1;
				if(direction==1) {
					if(isAir(p.getLocation().subtract(0, 0, 1).getBlock().getType())==false) {
						p.getWorld().spawnParticle(Particle.BLOCK_CRACK, l, 30, 0,0,0,0.05f, p.getLocation().subtract(0, 0, 1).getBlock().getType().createBlockData());
							return true;
					}
					else {
						return false;
					}
				}
				else if(direction==2) {
					if(isAir(p.getLocation().add(1, 0, 0).getBlock().getType())==false) {
						p.getWorld().spawnParticle(Particle.BLOCK_CRACK, l, 30, 0,0,0,0.05f, p.getLocation().add(1, 0, 0).getBlock().getType().createBlockData());
							return true;
					}
					else {
						return false;
					}
				}
				else if(direction==3||direction==-1) {
					if(isAir(p.getLocation().add(0, 0, 1).getBlock().getType())==false) {
						p.getWorld().spawnParticle(Particle.BLOCK_CRACK, l, 30, 0,0,0,0.05f, p.getLocation().add(0, 0, 1).getBlock().getType().createBlockData());
							return true;
					}
					else {
						return false;
					}
				}
				else if(direction==4||direction==0) {
					if(isAir(p.getLocation().subtract(1, 0, 0).getBlock().getType())==false) {
						p.getWorld().spawnParticle(Particle.BLOCK_CRACK, l, 30, 0,0,0,0.05f, p.getLocation().subtract(1, 0, 0).getBlock().getType().createBlockData());
							return true;
					}
					else {
						return false;
					}
				}
			}
			return false;
		}
		
		public boolean getLookingAt2(LivingEntity player, LivingEntity player1) {
			Location eye = player.getEyeLocation();
			Vector toEntity = ((LivingEntity) player1).getEyeLocation().toVector().subtract(eye.toVector());
			double dot = toEntity.normalize().dot(eye.getDirection());
			if( (1D - (scopePower.get( ( (Player) player ).getName() ) + getInAirReach((Player) player)) )<=.01) {
				return dot > 0.01D;
			}
			else {
			return dot > (1D-(scopePower.get( ( (Player) player ).getName() ) + getInAirReach((Player) player)));
			}
		}
		
		public boolean getLookingAt(LivingEntity player, Entity player1) {
			Location eye = player.getEyeLocation();
			Vector toEntity = ((Entity) player1).getLocation().toVector().subtract(eye.toVector());
			double dot = toEntity.normalize().dot(eye.getDirection());
			if((0.85D-scopePower.get(((Player) player).getName()))<=.01) {
				return dot > 0.01D;
			}
			else {
			return dot > (0.85D-scopePower.get(((Player) player).getName()));
			}
		}
		
		public boolean getLookingAt(LivingEntity player, Entity player1, float scope) {
			Location eye = player.getEyeLocation();
			Vector toEntity = ((Entity) player1).getLocation().toVector().subtract(eye.toVector());
			double dot = toEntity.normalize().dot(eye.getDirection());
			if((0.85D-scope)<=.01) {
				return dot > 0.01D;
			}
			else {
			return dot > (0.85D-scope);
			}
		}

		public double getPower(ItemStack i, PlayerInventory i2) {
			if(i!=null) {
				if(i.getType()==Material.AIR) {
					return 1.1;
				}
				else if(i.getType()==Material.WOODEN_SWORD||i.getType()==Material.WOODEN_AXE) {
					return 1.15;
				}
				else if(i.getType()==Material.STONE_SWORD||i.getType()==Material.STONE_AXE) {
					return 1.30;
				}
				else if(i.getType()==Material.IRON_SWORD||i.getType()==Material.IRON_AXE) {
					return 1.45;
				}
				else if(i.getType()==Material.GOLDEN_SWORD||i.getType()==Material.GOLDEN_AXE) {
					return 1.65;
				}
				else if(i.getType()==Material.DIAMOND_SWORD||i.getType()==Material.DIAMOND_AXE) {
					return 1.85;
				}
			}
			else {
				return 1.1;
			}
			return 1.1;
		}
		
		public Material getSword(ItemStack i) {
			if(i!=null) {
				if(i.getType()==Material.AIR) {
					return Material.AIR;
				}
				else if(i.getType()==Material.WOODEN_SWORD) {
					return Material.WOODEN_SWORD;
				}
				else if(i.getType()==Material.STONE_SWORD) {
					return Material.STONE_SWORD;
				}
				else if(i.getType()==Material.IRON_SWORD) {
					return Material.IRON_SWORD;
				}
				else if(i.getType()==Material.GOLDEN_SWORD) {
					return Material.GOLDEN_SWORD;
				}
				else if(i.getType()==Material.DIAMOND_SWORD) {
					return Material.DIAMOND_SWORD;
				}
				else if(i.getType()==Material.WOODEN_AXE) {
					return Material.WOODEN_AXE;
				}
				else if(i.getType()==Material.STONE_AXE) {
					return Material.STONE_AXE;
				}
				else if(i.getType()==Material.IRON_AXE) {
					return Material.IRON_AXE;
				}
				else if(i.getType()==Material.GOLDEN_AXE) {
					return Material.GOLDEN_AXE;
				}
				else if(i.getType()==Material.DIAMOND_AXE) {
					return Material.DIAMOND_AXE;
				}
			}
			else {
				return Material.AIR;
			}
			return Material.AIR;
		}
		
		public int getTime(ItemStack i, PlayerInventory i2) {
			if(i!=null) {
				if(i.getType()==Material.AIR) {
					return 2;
				}
				else if(i.getType()==Material.WOODEN_SWORD) {
					return 2;
				}
				else if(i.getType()==Material.STONE_SWORD) {
					return 3;
				}
				else if(i.getType()==Material.IRON_SWORD) {
					return 3;
				}
				else if(i.getType()==Material.GOLDEN_SWORD) {
					return 4;
				}
				else if(i.getType()==Material.DIAMOND_SWORD) {
					return 4;
				}
			}
			else {
				return 2;
			}
			return 2;
		}
		
		public double getRemain(double t1, double t2) {
			if(t1==2) {
				double tn = t2-.5;
				if(tn<0||tn>1) {
					return 0;
				}
				else {
				return t2-.5;
				}
			}
			else if(t1==3) {
				double tn = t2-.3;
				if(tn<0||tn>1) {
					return 0;
				}
				else {
				return t2-.5;
				}
			}
			else{
				double tn = t2-.2;
				if(tn<0||tn>1) {
					return 0;
				}
				else {
				return t2-.5;
				}
			}
		}
		
		public void countDown(Player p){
			if(jumpcd.get(p.getName()).getBossBar()==null) {
			BossBar b = Bukkit.createBossBar(ChatColor.RED + "Jump Cooldown", BarColor.RED, BarStyle.SEGMENTED_10);
			b.addPlayer(p);
			jumpcd.get(p.getName()).replaceBossBar(b);
			}
			if(jumpcd.get(p.getName()).count==0) {
					jumpcd.get(p.getName()).getBossBar().removePlayer(p);
					jumpcd.get(p.getName()).replaceBossBar(null);
					return;
			}
			else {
				jumpcd.get(p.getName()).removeTime(0);
				jumpcd.get(p.getName()).getBossBar().setProgress(getRemain(((jumpcd.get(p.getName()).tempSec2/1000)+1.25), jumpcd.get(p.getName()).getBossBar().getProgress()));
			Bukkit.getScheduler()
			.runTaskLater(this,
					() -> countDown(p),
					8);
			}
		}
		
		public static void removeItemNaturallyA2(Player p, int i) {
			if (p.getInventory().getItem(i).getAmount() <= 1) {
				p.getInventory().getItem(i).setAmount(0);
			} else {
				p.getInventory().getItem(i).setAmount(p.getInventory().getItem(i).getAmount() - 1);
			}
		}
		
		@EventHandler
		public void onPlayerJoin2(PlayerJoinEvent e) {
			if(!jumpcd.containsKey(e.getPlayer().getName())) {
				PlayerCountDown cd = new PlayerCountDown(e.getPlayer().getName());
				jumpcd.put(e.getPlayer().getName(), cd);
			}
			if(velocityPower.get(e.getPlayer().getName())==null) {
				velocityPower.put(e.getPlayer().getName(), (float) .85);
			}
			if(strengthPower.get(e.getPlayer().getName())==null) {
				strengthPower.put(e.getPlayer().getName(), (float) 1);
			}
			if(magicPower.get(e.getPlayer().getName())==null) {
				magicPower.put(e.getPlayer().getName(), (float) 1);
			}
			if(resisPower.get(e.getPlayer().getName())==null) {
				resisPower.put(e.getPlayer().getName(), (float) .001);
			}
			if(attackPower.get(e.getPlayer().getName())==null) {
				attackPower.put(e.getPlayer().getName(), (float) 1);
			}
			if(reachPower.get(e.getPlayer().getName())==null) {
				reachPower.put(e.getPlayer().getName(), (float) .01);
			}
			if(scopePower.get(e.getPlayer().getName())==null) {
				scopePower.put(e.getPlayer().getName(), (float) .2);
			}
		}
		
		//
		
		//armor abilities
		
		// possible lag from engine power - could just be server
		
		ArrayList<Player> ability8 = new ArrayList<Player>();
		ArrayList<Player> ability27 = new ArrayList<Player>();
		ArrayList<Player> ability36 = new ArrayList<Player>();
		ArrayList<Player> ability41 = new ArrayList<Player>();
		ArrayList<Player> ability44 = new ArrayList<Player>();
		ArrayList<Player> ability45 = new ArrayList<Player>();
		
		//
		
		@EventHandler
		public void checkEnabledAbiltiesOnJoin(PlayerJoinEvent e) {
			if(artifactsE) {
			Player p = e.getPlayer();
			if(shopGUIS.enabled.containsKey(e.getPlayer().getName())) {
			List<Integer> abilities = shopGUIS.enabled.get(e.getPlayer().getName());
			if(abilities.contains(8)) {
				ability8.add(p);
			}
			if(abilities.contains(27)) {
				ability27.add(p);
			}
			if(abilities.contains(45)) {
				ability45.add(p);
			}
			if(abilities.contains(41)) {
				ability41.add(p);
				diamondm.put(p, new ArrayList<Entity>());
			}
			}
			else {
				shopGUIS.enabled.put(e.getPlayer().getName(), new ArrayList<Integer>());
			}
			}
		}
		
		public void enabledAbility(int abilnum, Player p) {
			resetInventory(abilnum, p);
			enabledAbilityA(abilnum, p);
			enabledAbilityP(abilnum, p);
			if(abilnum == 8) {
				if(!ability8.contains(p)) {
					ability8.add(p);
				}
			}
			if(abilnum == 27) {
				if(!ability27.contains(p)) {
					ability27.add(p);
				}
			}
			if(abilnum == 45) {
				if(!ability45.contains(p)) {
					ability45.add(p);
				}
			}
			if(abilnum == 41) {
				if(!ability41.contains(p)) {
					ability41.add(p);
					if(!diamondm.containsKey(p)) {
					diamondm.put(p, new ArrayList<Entity>());
					}
				}
			}
		}
		
		public void disabledAbility(int abilnum, Player p) {
			disabledAbilityA(abilnum, p);
			disabledAbilityP(abilnum, p);
			if(abilnum == 8) {
				if(ability8.contains(p)) {
					ability8.remove(p);
				}
			}
			if(abilnum == 27) {
				if(ability27.contains(p)) {
					ability27.remove(p);
				}
			}
			if(abilnum == 36) {
				if(ability36.contains(p)) {
					ability36.remove(p);
				}
			}
			if(abilnum == 44) {
				if(ability44.contains(p)) {
					ability44.remove(p);
				}
			}
			if(abilnum == 45) {
				if(ability45.contains(p)) {
					ability45.remove(p);
				}
			}
			if(abilnum == 41) {
				if(ability41.contains(p)) {
					ability41.remove(p);
				}
				if(diamondm.containsKey(p)) {
					diamondm.remove(p);
				}
			}
		}
		
		@EventHandler
		public void interact(PlayerInteractEvent e){
		        Action eventAction = e.getAction();
		        Player player = e.getPlayer();
		        if(!shopGUIS.enabled.containsKey(player.getName())) {
					return;
				}
		      if (eventAction == Action.RIGHT_CLICK_AIR){
		    	  if(shopGUIS.enabled.get(player.getName()).contains(217)) {
		            if (player.getInventory().getItemInMainHand().getType().equals(Material.FIRE_CHARGE)){
		                player.launchProjectile(LargeFireball.class).setVelocity(player.getLocation().getDirection().multiply(0.5));
		                removeItemNaturally(player);
		            }
		    	  }
		            Player p = player;
		            if(shopGUIS.enabled.get(p.getName()).contains(43)) {
							if(p.isSneaking()) {
								if(deleteDiamondArmor(p)) {
								p.setSneaking(false);
								diamondShard(p);
								}
							}
					}
		            if(shopGUIS.enabled.get(p.getName()).contains(44) && (!ability44.contains(p))) {
		            	if(p.isSneaking()) {	
		            			if(p.getLevel()>=15) {
		            				p.getWorld().playSound(p.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LARGE_BLAST_FAR, 1, 2);
		            				Bukkit.getScheduler().runTaskLater(this, () -> p.getWorld().playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 2), 20);
		            				Bukkit.getScheduler().runTaskLater(this, () -> p.getWorld().playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 2), 40);
		            				Bukkit.getScheduler().runTaskLater(this, () -> p.getWorld().playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 2), 60);
		            				ability44.add(p);
		            				p.setLevel(p.getLevel()-15);
		            				addPotionEffectBetter(p, PotionEffectType.SPEED, 2400, 9, true, true, false);
		            				p.setSneaking(false);
		            			}
		            	}
		            }
		      }
		}
		
		@EventHandler
	    public void onPlayerShift(PlayerToggleSneakEvent e){
			Player p = e.getPlayer();
			if(!notnpc(p)) {
				return;
			}
			if(!shopGUIS.enabled.containsKey(p.getName())) {
				return;
			}
			if(p.isOnGround()) {
				if(shopGUIS.enabled.get(p.getName()).contains(34)) {
					p.setVelocity(p.getVelocity().add(new Vector(0, 3.7, 0)));
					p.getWorld().playSound(p.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 1, (float) 1);
					onFirework(0, p);
				}
				if(shopGUIS.enabled.get(p.getName()).contains(36)) {
					doShockWave(p);
				}
			}
			doSneakP(p);
		}
		
		public void onFirework(int time, Player p) {
			if(p == null) {
				return;
			}
			if(time >= 34 || p.isOnline()==false) {
				if(p.isOnline()==false) {
					return;
				}
				Location loc = p.getLocation();
		        Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
		        FireworkMeta fwm = fw.getFireworkMeta();
		        fwm.setPower(2);
		        fwm.addEffect(FireworkEffect.builder().withColor(Color.BLUE).flicker(true).build());
		        fw.setFireworkMeta(fwm);
		        Bukkit.getScheduler().runTaskLater(this, () -> fw.detonate(), (long) 2);
				return;
			}
			else {
		    p.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, p.getLocation(), 1, 0, 0, 0, 0.001);
			Bukkit.getScheduler().runTaskLater(this, () -> onFirework(time+1, p), (long) 1);
			}
		}
		
		@EventHandler
	    public void onDamageEvent(EntityDamageByEntityEvent e){
	        if (notnpc(e.getEntity()) && (e.getDamager() instanceof LivingEntity)) {
	            LivingEntity damager = (LivingEntity) e.getDamager();
	            Player p = (Player) e.getEntity();
	            if(!shopGUIS.enabled.containsKey(p.getName())) {
					return;
				}
	            if(shopGUIS.enabled.get(p.getName()).contains(32)) {
	            	Bukkit.getScheduler().runTaskLater(this, () -> p.setVelocity(new Vector(0, 0, 0)), (long) 1);
	            }
	            else if(shopGUIS.enabled.get(p.getName()).contains(16)) {
	            Bukkit.getScheduler().runTaskLater(this, () ->  p.setVelocity(damager.getLocation().getDirection().setY(0).normalize().multiply(.25)), (long) 2);
	            }
	        }
	    }
		
		@EventHandler
		public void onFireAndLavaDamage(EntityDamageEvent e) {
			if(notnpc(e.getEntity())) {
				Player p = (Player) e.getEntity();
				if(!shopGUIS.enabled.containsKey(p.getName())) {
					return;
				}
				if(shopGUIS.enabled.get(p.getName()).contains(14)){
					if(e.getCause() == DamageCause.FIRE || e.getCause() == DamageCause.FIRE_TICK || e.getCause() == DamageCause.LAVA) {
						e.setCancelled(true);
						p.setFireTicks(0);
					}
				}
				if(shopGUIS.enabled.get(p.getName()).contains(32)){
						if(e.getCause() == DamageCause.FALL) {
							Location l = p.getLocation().subtract(0, 1, 0);
							l.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, l.clone(), 1);
							l.getWorld().playSound(l, Sound.ENTITY_GENERIC_EXPLODE, (float) .7, (float) 1.3);
							List<Block> locations = new ArrayList<Block>();
							int ammount = randor.nextInt(4)+4;
							for(int count = 0; count < ammount; count++) {
							Location start = l.clone();
							Location end = l.clone().add(coinFlip()*randor.nextInt(3)+1, 0, coinFlip()*randor.nextInt(3)+1);
							double step = .3D;
							Vector line = end.toVector().subtract(start.toVector());
							for (double d = 0; d < line.length()/2.0; d += step) {
								final double dd = d;
								Block newloc = start.clone().add(line.clone().multiply(dd)).getBlock();
								if(!locations.contains(newloc) && (newloc != l.getBlock())) {
									locations.add(newloc);
								}
							}
							}
							for(Block b : locations) {
								if(b.getLocation() != p.getLocation().subtract(0, 1, 0).getBlock().getLocation()) {
								l.getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, b.getLocation().add(0.5, 0.5, 0.5), 1);
								b.setType(Material.AIR);
								}
							}
						}
				}
				if(shopGUIS.enabled.get(p.getName()).contains(42)){
					p.getWorld().playSound(p.getLocation(), Sound.BLOCK_GLASS_BREAK, (float) .7, (float) 1);
				}
			}
		}
		
		@EventHandler
		public void OnPlayerMove(PlayerMoveEvent e) {
			if(!shopGUIS.enabled.containsKey(e.getPlayer().getName())) {
				return;
			}
			if(shopGUIS.enabled.get(e.getPlayer().getName()).contains(5)) {
				if(e.getPlayer().getPotionEffect(PotionEffectType.SPEED)!=null) {

				}
				else {
					e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));
				}
			}
			if(shopGUIS.enabled.get(e.getPlayer().getName()).contains(156)) {
				if(e.getPlayer().getPotionEffect(PotionEffectType.SLOW)!=null) {

				}
				else {
					e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 999999, 2, false, false));
				}
			}
			if(shopGUIS.enabled.get(e.getPlayer().getName()).contains(15)) {
				Player p = e.getPlayer();
				if((p.getWorld().getTime()>12500&&p.getWorld().getTime()<22900)||(p.getLocation().getBlock().getLightLevel()<6)) {
					if(p.getPotionEffect(PotionEffectType.NIGHT_VISION)!=null) {
						
					}
					else {
						p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 0, false, false));
					}
				}
				else {
					if(p.getPotionEffect(PotionEffectType.NIGHT_VISION)!=null) {
						p.removePotionEffect(PotionEffectType.NIGHT_VISION);
					}
				}
			}
		}
		
		@EventHandler
		public void OnDamaged(EntityDamageByEntityEvent e) {
			if(notnpc(e.getEntity())) {
				Player p = (Player) e.getEntity();
				if(!shopGUIS.enabled.containsKey(p.getName())) {
					return;
				}
				List<Integer> abilities = shopGUIS.enabled.get(p.getName());
				if(randor.nextInt(8)==1) {
					if(abilities.contains(6)) {
						e.setCancelled(true);
						p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "You skillfully dodged the attack!");
						p.getWorld().playSound(e.getDamager().getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 1, (float) .9);
					}
				}
				if(randor.nextInt(8)==1) {
					if(abilities.contains(7)) {
						if(e.getDamager() instanceof Player) {
						damagePlayerReason((Player) e.getDamager(), 1 + attackPower.get(p.getName()), "");
						}
						else if(e.getDamager() instanceof LivingEntity){
							((LivingEntity) e.getDamager()).damage(1 + attackPower.get(p.getName()), e.getEntity());
						}
						p.getWorld().playSound(e.getDamager().getLocation(), Sound.ENCHANT_THORNS_HIT, 1, 1);
					}
				}
				if(randor.nextInt(7)==1) {
					if(abilities.contains(9)) {
						if(e.getDamager() instanceof LivingEntity){
							((LivingEntity) e.getDamager()).setFireTicks(90);
							p.getWorld().spawnParticle(Particle.FLAME, e.getDamager().getLocation().add(0.5, 0.5, 0.5), 15, .5, .5, .5, 0.04);
							p.getWorld().spawnParticle(Particle.LAVA, e.getDamager().getLocation().add(0.5, 0.5, 0.5), 5);
							p.getWorld().playSound(e.getDamager().getLocation(), Sound.ITEM_FIRECHARGE_USE, 1, 1);
						}
					}
				}
				if(randor.nextInt(7)==1) {
					if(abilities.contains(17)) {
						doFireRune(p, e.getDamager().getLocation());
					}
				}
				if(randor.nextInt(7)==1) {
					if(abilities.contains(18)) {
						doShrapnel(p);
					}
				}
				if(randor.nextInt(7)==1) {
					if(abilities.contains(23)) {
						doGrapplingEffects(p, e.getDamager());
					}
				}
				if(randor.nextInt(7)==1) {
					if(abilities.contains(24)) {
						p.getWorld().playSound(e.getDamager().getLocation(), Sound.ENCHANT_THORNS_HIT, 1, 0);
						Bukkit.getScheduler().runTaskLater(this, () -> p.getWorld().playSound(e.getDamager().getLocation(), Sound.ENCHANT_THORNS_HIT, 1, (float) 0.5), 15);
						Bukkit.getScheduler().runTaskLater(this, () -> p.getWorld().playSound(e.getDamager().getLocation(), Sound.ENCHANT_THORNS_HIT, 1, 1), 25);
						Bukkit.getScheduler().runTaskLater(this, () -> p.getWorld().playSound(e.getDamager().getLocation(), Sound.ENCHANT_THORNS_HIT, 1, 2), 35);
						Bukkit.getScheduler().runTaskLater(this, () -> p.getWorld().spawnParticle(Particle.CRIT, e.getDamager().getLocation().add(0.5, 1, 0.5), 25, 0.7, 1.2, 0.7), 45);
						Bukkit.getScheduler().runTaskLater(this, () -> doSpikeEffect(p, e.getDamager()), 45);
					}
				}
				if(randor.nextInt(7)==1) {
					if(abilities.contains(26)) {
						doFunnelEffect(e.getDamager());
					}
				}
			}
		}
		
		public void doShockWave(Player p) {
			if(!ability36.contains(p)) {
			p.getWorld().playSound(p.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_IMPACT, 1, (float) 0.2);
			 ability36.add(p);
			 final Player player = p;
			 new BukkitRunnable(){//
	                 double t = Math.PI/4;
	                 Location loc = player.getLocation();
	                 public void run(){//
	                         t = t + 0.1*Math.PI;
	                         for (double theta = 0; theta <= 2*Math.PI; theta = theta + Math.PI/32){
	                                 double x = t*Math.cos(theta);
	                                 double y = 2*Math.exp(-0.1*t) * Math.sin(t) + 1.5;
	                                 double z = t*Math.sin(theta);
	                                 loc.add(x,y,z);
	                                 p.getWorld().spawnParticle(Particle.SWEEP_ATTACK, loc, 1, 0, 0, 0, 0.001);
	                                 loc.subtract(x,y,z);
	                                
	                                 theta = theta + Math.PI/16;
	                         }
	                         if (t > 10){
	                        	 this.cancel();
	                         }
	                 }
			 }.runTaskTimer(this, 0, 1);
			 for(Entity e : p.getNearbyEntities(6, 3, 6)) {
				 if(e instanceof Monster || e instanceof Player) {
					 Vector v = e.getLocation().toVector().subtract(p.getLocation().toVector()).normalize().add(new Vector(0, 0.5, 0)).multiply(3);
					 e.setVelocity(e.getVelocity().add(v));
				 }
			 }
			Bukkit.getScheduler().runTaskLater(this, () -> ability36.remove(p), 180);
			}
		}
		
		public void doFunnelEffect(Entity e) {
			Location l = e.getLocation();
			int points = 110;
		    double radius = 0.5;
		    double step = 0;
		    int numSteps = 15;

		    double speed = 0;
		    if (step == 0) {
		       for (int i = 0; i < points; i++) {
		           double dx = Math.cos(Math.PI * 8 * ((double)i / points)) * radius;
		           double dz = Math.sin(Math.PI * 8 * ((double)i / points)) * radius;
		           final double y2 = i/50.0;
		           Bukkit.getScheduler().runTaskLater(this, () -> e.getWorld().spawnParticle(Particle.BLOCK_CRACK, l.clone().add(dx, y2, dz), 1, 0, 0, 0, .01, Material.DIRT.createBlockData()), i/8);
		           radius = radius - .001;
		           }
		      }
		    e.teleport(e.getLocation().subtract(0, 1, 0));
		    e.getWorld().playSound(e.getLocation(), Sound.BLOCK_GRASS_PLACE, 1, 1);
		    Bukkit.getScheduler().runTaskLater(this, () -> e.teleport(e.getLocation().subtract(0, 1, 0)), 25);
		    Bukkit.getScheduler().runTaskLater(this, () -> e.getWorld().playSound(e.getLocation(), Sound.BLOCK_GRASS_PLACE, 1, 1), 25);
		    Bukkit.getScheduler().runTaskLater(this, () -> e.teleport(e.getLocation().subtract(0, 1, 0)), 45);
		    Bukkit.getScheduler().runTaskLater(this, () -> e.getWorld().playSound(e.getLocation(), Sound.BLOCK_GRASS_PLACE, 1, 1), 45);
		}
		
		public void doSpikeEffect(Player p, Entity e) {
				if(e instanceof Player) {
				damagePlayerReason((Player) e, 3 + attackPower.get(p.getName())*2, "");
				}
				else if(e instanceof LivingEntity){
					((LivingEntity) e).damage(3 + attackPower.get(p.getName())*2, e);
				}
		}
		
		public void doGrapplingEffects(Player p, Entity a) {
			LivingEntity leashed = (LivingEntity) p.getWorld().spawnEntity(a.getLocation(), EntityType.CHICKEN);
			leashed.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 99999, 10, false, false));
			leashed.setSilent(true);
			leashed.setInvulnerable(true);
			leashed.setPassenger(a);
			leashed.setLeashHolder(p);
			leashed.setVelocity(p.getLocation().toVector()
					.subtract(leashed.getLocation().toVector()).normalize().multiply(2));
			Bukkit.getScheduler().runTaskLater(this, () -> leashed.remove(), 35);
		}
		
		public void doShrapnel(Player p) {
			p.getWorld().playSound(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, (float) .5, (float) 1.5);
			p.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, p.getLocation().add(0, 1, 0), 2);
			for(int count = 0; count < 20; count++) {
				ItemStack i = new ItemStack(Material.GOLD_NUGGET);
				ItemMeta im = i.getItemMeta();
				im.setLore(Arrays.asList("" + count));
				i.setItemMeta(im);
				Item item = p.getWorld().dropItemNaturally(p.getLocation().add(0, randor.nextInt(200)/100.0, 0), i);
				item.setPickupDelay(45);
				item.setVelocity(new Vector((coinFlip()*(randor.nextInt(3)+15))/100.0,(randor.nextInt(3)+30)/100.0,(coinFlip()*(randor.nextInt(3)+15))/100.0));
				Bukkit.getScheduler().runTaskLater(this, () -> item.remove(), 40);
			}
			for(Entity e : p.getNearbyEntities(2, 2, 2)) {
				if(e instanceof LivingEntity) {
					e.setVelocity(p.getLocation().toVector().add(e.getLocation().toVector()).normalize().multiply(2.6).add(new Vector(0, 1, 0).normalize()));
				}
			}
		}
		
		public void doFireRune(Player p, Location l2) {
			Location start = p.getLocation().clone().add(0, 1, 0);
			start.getWorld().playSound(start, Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 1, (float) .5);
			Location end = l2.clone().add(0, 1, 0);
			double step = 0.1D;

			Vector line = end.toVector().subtract(start.toVector());
			for (double d = 0; d < line.length()/2.0; d += step) {
				final double dd = d;
				Bukkit.getScheduler().runTaskLater(this, () ->  p.getWorld().spawnParticle(Particle.LAVA, start.clone().add(line.clone().multiply(dd)), 3, 0, 0, 0, 0.001), (long) (1*(d*10)));
			}
			Bukkit.getScheduler().runTaskLater(this, () -> doFireRuneCont(p, end), (long) ((line.length()/2.0)*10*1));
		}
		
		public void doFireRuneCont(Player p, Location l2) {
			float radius = 1.5f;
			Location location = l2.clone().add(0, 0, 0);
			for(float angle = 0f; angle < 6.4; angle += 0.1) {
			double x = (radius * Math.sin(angle));
			double z = (radius * Math.cos(angle));
			location.getWorld().spawnParticle(Particle.FLAME, location.getX()+x, location.getY(), location.getZ()+z, 0, 0, 1, 0);
			}
			p.getWorld().spawnParticle(Particle.LAVA, l2.add(.5, 0, .5), 10);
			p.getWorld().playSound(l2, Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1, (float) 1.5);
			Collection<Entity> e = l2.getWorld().getNearbyEntities(l2, 1.3, 2, 1.3);
			for(Entity entity : e) {
				if(entity instanceof LivingEntity) {
					if(entity instanceof Player && (entity != p)) {
						damagePlayerReason((Player) entity, 4, "none");
						entity.setFireTicks(120);
					}
					else if(entity instanceof Monster){
						((Monster) entity).damage(4, p);
						entity.setFireTicks(120);
					}
				}
			}
		}
		

		public void effectLooperF() {
			arrowEffectsF();
			swordEffectsF();
		}
		
		public void effectLooper() {
			arrowEffects();
			if(randor.nextInt(30)==0) {
			ArrayList<Player> ability8c = new ArrayList<Player>(ability8);
			for(Player p : ability8c) {
				if(p == null) {
					ability8.remove(p);
				}
				else if(p.isOnline()) {
						if(randor.nextInt(2)==0) {
							if(!(p.getHealth() + 4 > p.getHealthScale())) {
								p.setHealth(p.getHealth() + 4);
								p.playSound(p.getLocation(), Sound.ITEM_BOTTLE_FILL, 1, 1);
							}
							else {
								p.setHealth(p.getHealthScale());
							}
						}
				}
				else {
					ability8.remove(p);
				}
			}
			}
			ArrayList<Player> ability27c = new ArrayList<Player>(ability27);
			if(randor.nextInt(5)==0) {
				for(Player p : ability27c) {
					if(p.getHealth()<=4) {
					List<Entity> ents = p.getNearbyEntities(2, 2, 2);
					for(Entity es : ents) {
						if(es instanceof LivingEntity) {
							((LivingEntity) es).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION,120,1));
							((LivingEntity) es).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,120,0));
						}
						if(es instanceof Monster) {
							((Monster) es).setTarget(null);
						}
					}
					p.getWorld().spawnParticle(Particle.CLOUD, p.getLocation().add(0.5, 1, 0.5), 5, .7, 1.6, .7, 0.00f);
				}
				}
			}
			ArrayList<Player> ability45c = new ArrayList<Player>(ability45);
			for(Player p : ability45c) {
				if(p.isSneaking()) {
					if(randor.nextInt(12)==1) {
						damagePlayerReason(p, 1, "deal");
					}
					p.getWorld().playSound(p.getLocation(), Sound.ENTITY_FISHING_BOBBER_THROW, 1, 0);
					for(Entity e : p.getNearbyEntities(6.5, 6.5, 6.5)) {
						Vector v = e.getLocation().toVector().subtract(p.getLocation().toVector()).normalize();
						e.setVelocity(v);
					}
					if(randor.nextInt(10)==1) {
					doForcefieldParticles(p);
					}
				}
			}
			ArrayList<Player> ability44c = new ArrayList<Player>(ability44);
			for(Player p : ability44c) {
				if(p != null) {
					if(!p.hasPotionEffect(PotionEffectType.SPEED)) {
						if(shopGUIS.enabled.get(p.getName()).contains(5)) {
							p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false));
						}
						else if(shopGUIS.enabled.get(p.getName()).contains(42)) {
							addPotionEffectBetter(p, PotionEffectType.SPEED, 999999, 0, false, false, false);
						}
						ability44.remove(p);
					}
					else {
						p.getWorld().spawnParticle(Particle.FLAME, p.getLocation().add(0, 1, 0), 5, 0.3, 1, 0.3, 0.05);
					}
				}
				else {
					ability44.remove(p);
				}
			}
			ArrayList<Player> ability41c = new ArrayList<Player>(ability41);
			for(Player p : ability41c) {
				ArrayList<Entity> diamondm2 = new ArrayList<Entity>(diamondm.get(p));
				//spawn minion if player count is less than 3
				if(diamondm2.size() < ((int) (2 + magicPower.get(p.getName())))) {
					if(randor.nextInt(10)==1) {
						diamondm.get(p).add(spawnDiamondMinion(p));
					}
				}
				//check if any minions are gone
				for(Entity minion : diamondm2) {
					if(minion == null) {
						diamondm.get(p).remove(minion);
					}
				}
				//do minion effects
				for(Entity a : diamondm2) {
					ArmorStand as = (ArmorStand) a;
					if(randor.nextInt(4)!=0) {
						as.getWorld().spawnParticle(Particle.CLOUD, as.getEyeLocation(), 1, 0.1, 0.1, 0.1, 0.001);
					}
					else {
					as.getWorld().spawnParticle(Particle.DRIP_WATER, as.getEyeLocation(), 1, 0.1, 0.1, 0.1, 0.001);
					}
					if(as != null) {
						if(as.isDead()) {
						}
						else {
							EulerAngle ea = as.getHeadPose();
							as.setHeadPose(new EulerAngle(Math.toRadians(randor.nextInt(360)+1) + ea.getX(), Math.toRadians(randor.nextInt(360)+1) + ea.getY(), Math.toRadians(randor.nextInt(360)+1) + ea.getZ()));
						}
						
					}
					else {
					}
				}
				//check around player for enemies
				Entity enemy = null;
				for(Entity e : p.getNearbyEntities(8, 8, 8)) {
					if(e instanceof Monster || e instanceof Player) {
						enemy = e;
						break;
					}
				}
				//target enemy
				if(enemy != null) {
					for(Entity a : diamondm2) {
						if(randor.nextInt(4)==0) {
						a.getWorld().playSound(a.getLocation(), Sound.ENTITY_ARROW_SHOOT, 1, (float) 1.8);
						}
						Vector v = enemy.getLocation().toVector().subtract(a.getLocation().toVector()).normalize();
						a.setVelocity(v);
						for(Entity e : a.getWorld().getNearbyEntities(a.getLocation(), 1, 1, 1)) {
							if((e instanceof Monster || e instanceof Player) && (e != p)) {
								doDiamondMinionEffect(a.getLocation(), p);
								if(diamondm.get(p).contains(a)) {
								diamondm.get(p).remove(a);
								}
								a.remove();
								break;
							}
						}
					}
				}
				else {
				//buzz around player and return to player
					for(Entity a : diamondm2) {
						a.setVelocity(p.getLocation().add(0, 3.3, 0).toVector().subtract(a.getLocation().toVector()).normalize().multiply(1.3));
						a.setVelocity(getRandLoc(p.getLocation().add(0, 3.3, 0), 2).toVector().subtract(a.getLocation().toVector()).normalize().multiply(1.2));	
					}
				}
			}
		}
		
		public void doForcefieldParticles(Player p) {
			final Location loc = p.getLocation();
			new BukkitRunnable() {
				double phi = 0;
					public void run() {
						phi += Math.PI / 10;
						for(double theta = 0; theta <= 2*Math.PI; theta += Math.PI/10) {
							double r = 5;
							double x = r * Math.cos(theta) * Math.sin(phi);
							double y = r * Math.cos(phi) + 1.5;
							double z = r * Math.sin(theta) * Math.sin(phi);
							loc.add(x, y, z);
							if(randor.nextBoolean()) {
							p.getWorld().spawnParticle(Particle.END_ROD, loc, 1, 0, 0, 0, 0.0001);
							}
							loc.subtract(x, y, z);
						}
						if(phi > 2 * Math.PI) {
							this.cancel();
						}
					}
			}.runTaskTimer(this, 0, 1);
		}
		
		@EventHandler
		public void onFoodEat(PlayerItemConsumeEvent e) {
			Player p = e.getPlayer();
			if(!notnpc(p)) {
				return;
			}
			if(!shopGUIS.enabled.containsKey(p.getName())) {
				return;
			}
			if(e.getItem().hasItemMeta()) {
				ItemStack food = e.getItem();
				if(food.getItemMeta().hasDisplayName()) {
					String displayname = food.getItemMeta().getDisplayName();
					if(displayname.equals(ChatColor.WHITE + "Infinite Milk")) {
						ItemStack milk = shopGUIS.makeItem(Material.MILK_BUCKET.name(), ChatColor.WHITE + "Infinite Milk", Arrays.asList(""), false);
						Bukkit.getScheduler().runTaskLater(this, () -> p.getInventory().setItemInMainHand(milk), 5);
					}
					else if(displayname.equals(ChatColor.DARK_GREEN + "Infinite Carrot") && shopGUIS.enabled.get(p.getName()).contains(47)) {
						ItemStack carrot = shopGUIS.makeItem(Material.CARROT.name(), ChatColor.DARK_GREEN + "Infinite Carrot", Arrays.asList(ChatColor.GRAY + "Yummy carrot that never runs out."), false);
						Bukkit.getScheduler().runTaskLater(this, () -> p.getInventory().setItemInMainHand(carrot), 5);
					}
					else if(displayname.equals(ChatColor.GREEN + "Infinite Melon") && shopGUIS.enabled.get(p.getName()).contains(48)) {
						ItemStack melon = shopGUIS.makeItem(Material.MELON_SLICE.name(), ChatColor.GREEN + "Infinite Melon", Arrays.asList(ChatColor.GRAY + "Yummy melon that never runs out."), false);
						Bukkit.getScheduler().runTaskLater(this, () -> p.getInventory().setItemInMainHand(melon), 5);
					}
					else if(displayname.equals(ChatColor.RED + "Infinite Beef") && shopGUIS.enabled.get(p.getName()).contains(49)) {
						ItemStack rawbeef = shopGUIS.makeItem(Material.BEEF.name(), ChatColor.RED + "Infinite Beef", Arrays.asList(ChatColor.GRAY + "Yummy beef that never runs out."), false);
						Bukkit.getScheduler().runTaskLater(this, () -> p.getInventory().setItemInMainHand(rawbeef), 5);
					}
					else if(displayname.equals(ChatColor.BLUE + "Infinite Fish") && shopGUIS.enabled.get(p.getName()).contains(50)) {
						ItemStack cfish = shopGUIS.makeItem(Material.COOKED_COD.name(), ChatColor.BLUE + "Infinite Fish", Arrays.asList(ChatColor.GRAY + "Yummy fish that never runs out."), false);
						Bukkit.getScheduler().runTaskLater(this, () -> p.getInventory().setItemInMainHand(cfish), 5);
					}
					else if(displayname.equals(ChatColor.DARK_RED + "Infinite Steak") && shopGUIS.enabled.get(p.getName()).contains(51)) {
						ItemStack cbeef = shopGUIS.makeItem(Material.COOKED_BEEF.name(), ChatColor.DARK_RED + "Infinite Steak", Arrays.asList(ChatColor.GRAY + "Yummy steak that never runs out."), false);
						Bukkit.getScheduler().runTaskLater(this, () -> p.getInventory().setItemInMainHand(cbeef), 5);
					}
					else if(displayname.equals(ChatColor.DARK_AQUA + "Infinite Soup") && shopGUIS.enabled.get(p.getName()).contains(52)) {
						ItemStack msoup = shopGUIS.makeItem(Material.MUSHROOM_STEW.name(), ChatColor.DARK_AQUA + "Infinite Soup", Arrays.asList(ChatColor.GRAY + "Yummy soup that never runs out."), false);
						Bukkit.getScheduler().runTaskLater(this, () -> p.getInventory().setItemInMainHand(msoup), 5);
					}
					else if(displayname.equals(ChatColor.GOLD + "Infinite Life") && shopGUIS.enabled.get(p.getName()).contains(53)) {
						ItemStack gapple = shopGUIS.makeItem(Material.GOLDEN_APPLE.name(), ChatColor.GOLD + "Infinite Life", Arrays.asList(ChatColor.GRAY + "Yummy golden apple that never runs out."), false);
						Bukkit.getScheduler().runTaskLater(this, () -> p.getInventory().setItemInMainHand(gapple), 5);
					}
				}
			}
		}
		
		public void removeDiamondMinions(Player p) {
			if(diamondm.containsKey(p)) {
			for(Entity e : diamondm.get(p)) {
				if(e != null) {
				e.remove();
				}
			}
			diamondm.get(p).clear();
			}
		}
		
		public Entity spawnDiamondMinion(Player p) {
			p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1, (float) 1.5);
			Location l = p.getLocation().add(0, 1, 0);
			ArmorStand e = (ArmorStand) l.getWorld().spawnEntity(l, EntityType.ARMOR_STAND);
			
			e.setVisible(false);
			e.setCustomNameVisible(false);
			e.setBasePlate(false);
			e.setHelmet(new ItemStack(Material.DIAMOND_BLOCK, 1));
			
			return e;
		}
		
		public void doDiamondMinionEffect(Location l, Player p) {
			l.getWorld().playSound(l, Sound.BLOCK_ANVIL_HIT, 1, (float) 1.4);
			l.getWorld().spawnParticle(Particle.DRIP_WATER, l, 20, 1, 1, 1, 0.001);
			for(Entity e : l.getWorld().getNearbyEntities(l, 1, 1, 1)) {
				if((e instanceof Monster || e instanceof Player) && (e != p)) {
					if(e instanceof Monster) {
						((Monster) e).damage(4 + attackPower.get(p.getName()), p);
					}
					else {
						damagePlayerReasonPlayer(((Player) e), 4 + attackPower.get(p.getName()), "null", p);
					}
				}
			}
		}
		
		@EventHandler
	    public void manipulate(PlayerArmorStandManipulateEvent e)
	    {
			if(artifactsE) {
	            if(!e.getRightClicked().isVisible())
	            {
	                e.setCancelled(true);
	            }
			}
	    }
		
		public void spawnInstantFirework(Location l, int power, Color c) {
			Location loc = l;
	        Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
	        FireworkMeta fwm = fw.getFireworkMeta();
	        fwm.setPower(power);
	        fwm.addEffect(FireworkEffect.builder().withColor(c).flicker(true).build());
	        fw.setFireworkMeta(fwm);
	        Bukkit.getScheduler().runTaskLater(this, () -> fw.detonate(), (long) 2);
		}
		
		public void spawnColorParticle(Location l, int ammount, int r, int g, int b) {
			for(int count = 0; count < ammount; count++) {
			 	DustOptions dustOptions = new DustOptions(Color.fromRGB(r, g, b), 1);
			 	l.getWorld().spawnParticle(Particle.REDSTONE, l, 1, dustOptions);
			}
		}
		
		public void diamondShard(Player p) {
			addPotionEffectBetter(p, PotionEffectType.DAMAGE_RESISTANCE, 320, 1, false, false, false);
			addPotionEffectBetter(p, PotionEffectType.INCREASE_DAMAGE, 320, 1, false, false, false);
			spawnInstantFirework(p.getLocation().clone().add(0, 1, 0), 1, Color.AQUA);
			Location start = p.getLocation().clone().add(0, 1, 0);
			for(int count = 0; count < 25; count++) {
			Location end = getRandLoc(start.clone(), 4).clone().add(0, 1, 0);
			double step = 0.05D;

			Vector line = end.toVector().subtract(start.toVector());
			for (double d = 0; d < line.length()/2.0; d += step) {
				final double dd = d;
				Location l = start.clone().add(line.clone().multiply(dd));
				Bukkit.getScheduler().runTaskLater(this, () ->  spawnColorParticle(l, 1, 25, 255, 223), (long) (1*(d*5)));
			}
			if(randor.nextInt(4)==0) {
				spawnInstantFirework(end, 1, Color.AQUA);
			}
			if(randor.nextInt(4)==0) {
				p.getWorld().strikeLightning(end);
			}
			}
			for(Entity e : p.getNearbyEntities(4.5, 4.5, 4.5)) {
				if(e instanceof Monster || e instanceof Player) {
					if(e instanceof Monster) {
						((Monster) e).damage(16 + attackPower.get(p.getName())*3, p);
					}
					else {
						damagePlayerReasonPlayer(((Player) e), 16 + attackPower.get(p.getName())*3, "null", p);
					}
					addPotionEffectBetter(((LivingEntity) e), PotionEffectType.LEVITATION, 80, 1, false, false, false);
					addPotionEffectBetter(((LivingEntity) e), PotionEffectType.SLOW, 320, 1, false, false, false);
					addPotionEffectBetter(((LivingEntity) e), PotionEffectType.CONFUSION, 80, 1, false, false, false);
					addPotionEffectBetter(((LivingEntity) e), PotionEffectType.SLOW_DIGGING, 160, 1, false, false, false);
				}
				Vector v = e.getLocation().toVector().subtract(p.getLocation().toVector()).normalize().add(new Vector(0, 0.5, 0)).multiply(3);
				e.setVelocity(e.getVelocity().add(v));
			}
			p.getWorld().playSound(p.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_IMPACT, 1, (float) 1.8);
		}
		
		public boolean deleteDiamondArmor(Player p) {
			boolean hadArmor = false;
			ItemStack[] armor = p.getInventory().getArmorContents();
			for(int count = 0; count < armor.length; count++) {
				if(armor[count] != null) {
					Material m = armor[count].getType();
					if(m == Material.DIAMOND_LEGGINGS || m == Material.DIAMOND_CHESTPLATE || m == Material.DIAMOND_HELMET || m == Material.DIAMOND_BOOTS) {
						hadArmor = true;
						if(m == Material.DIAMOND_LEGGINGS) {
							p.getInventory().setLeggings(new ItemStack(Material.AIR));
						}
						else if(m == Material.DIAMOND_CHESTPLATE) {
							p.getInventory().setChestplate(new ItemStack(Material.AIR));
						}
						else if(m == Material.DIAMOND_HELMET) {
							p.getInventory().setHelmet(new ItemStack(Material.AIR));
						}
						else if(m == Material.DIAMOND_BOOTS) {
							p.getInventory().setBoots(new ItemStack(Material.AIR));
						}
						break;
					}
				}
			}
			return hadArmor;
		}
		
		//Bow Abilities
		
		List<Entity> ability84 = new ArrayList<Entity>();
		List<Entity> ability85 = new ArrayList<Entity>();
		static HashMap<String, Integer> ability87 = new HashMap<String, Integer>();
		List<Entity> ability88 = new ArrayList<Entity>();
		List<Entity> ability89 = new ArrayList<Entity>();
		List<Entity> ability93 = new ArrayList<Entity>();
		List<Entity> ability97 = new ArrayList<Entity>();
		List<Entity> ability98 = new ArrayList<Entity>();
		List<Entity> ability104 = new ArrayList<Entity>();
		List<Entity> ability110 = new ArrayList<Entity>();
		List<Entity> ability111 = new ArrayList<Entity>();
		List<Entity> ability113 = new ArrayList<Entity>();
		List<Entity> ability115 = new ArrayList<Entity>();
		List<Entity> ability119 = new ArrayList<Entity>();
		List<Entity> ability120 = new ArrayList<Entity>();
		List<Entity> ability121 = new ArrayList<Entity>();
		static HashMap<String, Integer> ability122 = new HashMap<String, Integer>();
		static HashMap<String, Integer> ability123 = new HashMap<String, Integer>();
		List<Entity> ability130 = new ArrayList<Entity>();
		List<Entity> ability131 = new ArrayList<Entity>();
		List<Entity> ability132 = new ArrayList<Entity>();
		
		@EventHandler
		public void checkEnabledAbiltiesOnJoinA(PlayerJoinEvent e) {
			if(artifactsE) {
			Player p = e.getPlayer();
			if(!notnpc(p)) {
				return;
			}
			if(shopGUIS.enabled.containsKey(e.getPlayer().getName())) {
			List<Integer> abilities = shopGUIS.enabled.get(e.getPlayer().getName());
			if(abilities.contains(87)) {
				if(!ability87.containsKey(p.getName())) {
				ability87.put(p.getName(), 0);
				}
			}
			if(abilities.contains(122)) {
				if(!ability122.containsKey(p.getName())) {
				ability122.put(p.getName(), 0);
				}
			}
			if(abilities.contains(123)) {
				if(!ability123.containsKey(p.getName())) {
				ability123.put(p.getName(), 0);
				}
			}
			}
			}
		}
		
		public void enabledAbilityA(int abilnum, Player p) {
			if(abilnum == 87) {
				if(!ability87.containsKey(p.getName())) {
					ability87.put(p.getName(), 0);
				}
			}
			if(abilnum == 122) {
				if(!ability122.containsKey(p.getName())) {
					ability122.put(p.getName(), 0);
				}
			}
			if(abilnum == 123) {
				if(!ability123.containsKey(p.getName())) {
					ability123.put(p.getName(), 0);
				}
			}
		}
		
		public void disabledAbilityA(int abilnum, Player p) {
			if(abilnum == 87) {
				if(ability87.containsKey(p.getName())) {
					ability87.remove(p.getName());
				}
			}
			if(abilnum == 122) {
				if(ability122.containsKey(p.getName())) {
					ability122.remove(p.getName());
				}
			}
			if(abilnum == 123) {
				if(ability123.containsKey(p.getName())) {
					ability123.remove(p.getName());
				}
			}
		}
		
		public void arrowEffectsF() {
			ArrayList<Entity> ability110c = new ArrayList<Entity>(ability110);
			for(Entity e : ability110c) {
				if(canArrow(e)) {
					if(e.getMetadata("110").size()>0) {
						Player p = Bukkit.getPlayer(e.getMetadata("110").get(0).asString());
						if(p != null) {
							Location l = e.getLocation().clone().add(0, 1.4, 0);
							l.setYaw(p.getLocation().getYaw());
							l.setPitch(p.getLocation().getPitch());
							p.teleport(l);
						}
					}
				}
				else {
					ability110.remove(e);
				}
			}
			ArrayList<Entity> ability89c = new ArrayList<Entity>(ability89);
			for(Entity e : ability89c) {
				if(canArrow(e)) {
					e.getWorld().playSound(e.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 1, 2);
					e.getWorld().spawnParticle(Particle.FLAME, e.getLocation(), 2, 0.1, 0.1, 0.1, 0.05);
					e.getWorld().spawnParticle(Particle.LAVA, e.getLocation(), 1, 0, 0, 0, 0.05);
					e.getWorld().spawnParticle(Particle.DRIP_LAVA, e.getLocation(), 3, 0, 0, 0, 0.005);
				}
				else {
					ability89.remove(e);
				}
			}
			ArrayList<Entity> ability93c = new ArrayList<Entity>(ability93);
			for(Entity e : ability93c) {
				if(canArrow(e)) {
					if(randor.nextBoolean()) {
					e.getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE, e.getLocation(), 1, 0, 0, 0, 0.005);
					}
					for(Entity near : e.getWorld().getNearbyEntities(e.getLocation(), 1, 1, 1)) {
						if(near instanceof Projectile && (near != e)) {
							near.remove();
						}
					}
				}
				else {
					ability93.remove(e);
				}
			}
			ArrayList<Entity> ability130c = new ArrayList<Entity>(ability130);
			for(Entity e : ability130c) {
				if(canArrow(e)) {
					e.getWorld().spawnParticle(Particle.WATER_BUBBLE, e.getLocation(), 1, 0, 0, 0, 0.0001);
				}
				else {
					ability130.remove(e);
				}
			}
		}
		
		public void arrowEffects() {
			playerEffects();
			ArrayList<Entity> ability113c = new ArrayList<Entity>(ability113);
			for(Entity e : ability113c) {
				if(canArrow(e)) {
						e.getWorld().spawnParticle(Particle.SLIME, e.getLocation(), 1, 0, 0, 0, 0.0001);
						if(randor.nextInt(3)==0) {
							e.getWorld().playSound(e.getLocation(), Sound.ENTITY_SLIME_SQUISH, 1, 1);
						}
				}
				else {
					ability113.remove(e);
				}
			}
			ArrayList<Entity> ability115c = new ArrayList<Entity>(ability115);
			for(Entity e : ability115c) {
				if(canArrow(e)) {
						e.getWorld().playSound(e.getLocation(), Sound.ENTITY_HORSE_BREATHE, (float) .3, (float) 0.7);
				}
				else {
					ability115.remove(e);
				}
			}
			ArrayList<Entity> ability131c = new ArrayList<Entity>(ability131);
			for(Entity e : ability131c) {
				if(canArrow(e)) {
						e.getWorld().spawnParticle(Particle.BLOCK_CRACK, e.getLocation().getX(), e.getLocation().getY(), e.getLocation().getZ(), 1, Material.BONE_BLOCK.createBlockData());
				}
				else {
					ability131.remove(e);
				}
			}
			ArrayList<Entity> ability132c = new ArrayList<Entity>(ability132);
			for(Entity e : ability132c) {
				if(canArrow(e)) {
						e.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, e.getLocation(), 1, 0, 0, 0, 0.0001);
				}
				else {
					ability132.remove(e);
				}
			}
			ArrayList<Entity> ability119c = new ArrayList<Entity>(ability119);
			for(Entity e : ability119c) {
				if(canArrow(e)) {
						e.getWorld().spawnParticle(Particle.TOTEM, e.getLocation(), 1, 0, 0, 0, 0.0001);
				}
				else {
					ability119.remove(e);
				}
			}
			ArrayList<Entity> ability120c = new ArrayList<Entity>(ability120);
			for(Entity e : ability120c) {
				if(canArrow(e)) {
						e.getWorld().spawnParticle(Particle.CRIT, e.getLocation(), 1, 0, 0, 0, 0.0001);
				}
				else {
					ability120.remove(e);
				}
			}
			ArrayList<Entity> ability121c = new ArrayList<Entity>(ability121);
			for(Entity e : ability121c) {
				if(canArrow(e)) {
						e.getWorld().spawnParticle(Particle.BARRIER, e.getLocation(), 1, 0, 0, 0, 0.0001);
				}
				else {
					ability121.remove(e);
				}
			}
			ArrayList<Entity> ability111c = new ArrayList<Entity>(ability111);
			for(Entity e : ability111c) {
				if(canArrow(e)) {
						e.getWorld().spawnParticle(Particle.SPELL_WITCH, e.getLocation(), 1, 0, 0, 0, 0.0001);
				}
				else {
					ability111.remove(e);
				}
			}
			ArrayList<Entity> ability84c = new ArrayList<Entity>(ability84);
			for(Entity e : ability84c) {
				if(canArrow(e)) {
						e.getWorld().spawnParticle(Particle.END_ROD, e.getLocation(), 1, 0, 0, 0, 0.0001);
				}
				else {
					ability84.remove(e);
				}
			}
			ArrayList<Entity> ability98c = new ArrayList<Entity>(ability98);
			for(Entity e : ability98c) {
				if(canArrow(e)) {
						if(e.getTicksLived()>6000||(e.getVelocity().getX()<=0.005&&e.getVelocity().getY()<=0.005&&e.getVelocity().getZ()<=0.005)) {
							ability98.remove(e);
							e.remove();
						}
				}
				else {
					ability98.remove(e);
				}
			}
			ArrayList<Entity> ability104c = new ArrayList<Entity>(ability104);
			for(Entity e : ability104c) {
				if(canArrow(e)) {
						e.getWorld().spawnParticle(Particle.CLOUD, e.getLocation(), 1, 0, 0, 0, 0.0001);
						if(randor.nextBoolean()) {
							LlamaSpit ls = (LlamaSpit) e.getWorld().spawnEntity(e.getLocation(), EntityType.LLAMA_SPIT);
							if(Bukkit.getEntity(UUID.fromString(larry)) != null) {
								ls.setShooter((ProjectileSource) ((Llama) Bukkit.getEntity(UUID.fromString(larry))));
							}
						}
				}
				else {
					ability97.remove(e);
				}
			}
			ArrayList<Entity> ability97c = new ArrayList<Entity>(ability97);
			for(Entity e : ability97c) {
				if(canArrow(e)) {
						e.getWorld().spawnParticle(Particle.WATER_DROP, e.getLocation(), 1, 0, 0, 0, 0.0001);
				}
				else {
					ability97.remove(e);
				}
			}
			ArrayList<Entity> ability85c = new ArrayList<Entity>(ability85);
			for(Entity e : ability85c) {
				if(canArrow(e)) {
					if(randor.nextInt(3)==1) {
						e.getWorld().spawnParticle(Particle.FLAME, e.getLocation(), 1, 0, 0, 0, 0.005);
					}
				}
				else {
					ability85.remove(e);
				}
			}
			ArrayList<Entity> ability88c = new ArrayList<Entity>(ability88);
			for(Entity e : ability88c) {
				if(canArrow(e)) {
					if(randor.nextInt(2)==1) {
						e.getWorld().spawnParticle(Particle.FLAME, e.getLocation().add(0, 0.5, 0), 4, 0.5, 0.5, 0.5, 0.005);
					}
					for(Entity near : e.getWorld().getNearbyEntities(e.getLocation(), 1, 1, 1)) {
						if(near instanceof LivingEntity && (!(near instanceof Silverfish))) {
							((LivingEntity) near).setFireTicks(100);
							if(near instanceof Player) {
								damagePlayerReason(((Player) near), 1, "deal");
							}
							else {
								((LivingEntity) near).damage(1);
							}
						}
					}
				}
				else {
					ability88.remove(e);
				}
			}
		}
		
		public boolean canArrow(Entity e) {
			if(e == null) {
				return false;
			}
			if(e.isDead()) {
				return false;
			}
			if(e.getLocation().getY()>350||e.getLocation().getY()<0) {
				return false;
			}
			return true;
		}
	
		@EventHandler
		public void playerShootBow2(EntityShootBowEvent e) {
			if(inSpawnRegion(e.getEntity().getLocation())) {
				return;
			}
			if(notnpc(e.getEntity())) {
				Player p = (Player) e.getEntity();
				if(!shopGUIS.enabled.containsKey(p.getName())) {
					return;
				}
				int count = 1;
				Vector finalv = new Vector(0,0,0);
				List<Integer> abilities = new ArrayList<Integer>(shopGUIS.enabled.get(p.getName()));
				if(abilities.contains(103)) {
					count = 3;
				}
				if(abilities.contains(124)) {
					count = 5;
				}
				if(abilities.contains(128)) {
					count = 7;
				}
				for(int iteration = 0; iteration < count; iteration++) {
				Projectile a = null;
				if(iteration == 0) {
					a = (Projectile) e.getProjectile();
				}
				if(iteration != 0) {
					a = p.launchProjectile(Arrow.class);
					((Arrow) a).setPickupStatus(org.bukkit.entity.AbstractArrow.PickupStatus.DISALLOWED);
				}
				Vector v = a.getVelocity();
				if(abilities.contains(88)) {
					e.setCancelled(true);
					return;
				}
				if(abilities.contains(86)) {
					e.setCancelled(true);
					Entity a2 = p.launchProjectile(SmallFireball.class);
					v = p.getLocation().getDirection().multiply(1.5);
					a = (Projectile) a2;
				}
				if(abilities.contains(87)) {
					if(ability87.containsKey(p.getName())) {
						if(iteration == 0) {
						if(ability87.get(p.getName())>=3) {
							e.setCancelled(true);
							Entity a2 = p.launchProjectile(LargeFireball.class);
							v = p.getLocation().getDirection().multiply(1.0);
							a = (Projectile) a2;
							ability87.put(p.getName(), 0);
							p.getWorld().playSound(p.getLocation(), Sound.ENTITY_GHAST_SHOOT, 1, (float) 0.8);
						}
						else {
							p.getWorld().playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1, (float) 1.6);
							int time = ability87.get(p.getName());
							ability87.put(p.getName(), time + 1);
						}
						}
					}
				}
				if(abilities.contains(122)) {
					if(ability122.containsKey(p.getName())) {
						if(iteration == 0) {
						if(ability122.get(p.getName())>=3) {
							Entity a2 = p.getWorld().spawnEntity(p.getLocation().add(0, 1.5, 0), EntityType.PRIMED_TNT);
							a2.setVelocity(a.getVelocity());
							ability122.put(p.getName(), 0);
							p.getWorld().playSound(p.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1, (float) 0.8);
						}
						else {
							if(iteration == 0) {
							p.getWorld().playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1, (float) 1.6);
							int time = ability122.get(p.getName());
							ability122.put(p.getName(), time + 1);
							}
						}
						}
					}
				}
				if(abilities.contains(123)) {
					if(ability123.containsKey(p.getName())) {
						if(iteration == 0) {
						if(ability123.get(p.getName())>=5) {
							e.setCancelled(true);
							Entity a2 = p.launchProjectile(DragonFireball.class);
							v = p.getLocation().getDirection().multiply(1.0);
							a = (Projectile) a2;
							ability123.put(p.getName(), 0);
							p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_SHOOT, 1, (float) 0.8);
						}
						else {
							p.getWorld().playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1, (float) 1.6);
							int time = ability123.get(p.getName());
							ability123.put(p.getName(), time + 1);
						}
						}
					}
				}
				if(abilities.contains(89)) {
					v.multiply(2);
					if(a instanceof Arrow) {
						destroyArrow((Arrow) a);
					}
					ability89.add(a);
					a.setMetadata("89", new FixedMetadataValue(this, 0));
				}
				if(abilities.contains(84)) {
					ability84.add(a);
					a.setMetadata("84", new FixedMetadataValue(this, 0));
				}
				if(abilities.contains(132)) {
					ability132.add(a);
					a.setMetadata("132", new FixedMetadataValue(this, 0));
				}
				if(abilities.contains(85)) {
					ability85.add(a);
					a.setMetadata("85", new FixedMetadataValue(this, 0));
				}
				if(abilities.contains(107)) {
					a.setMetadata("107", new FixedMetadataValue(this, 0));
				}
				if(abilities.contains(93)) {
					ability93.add(a);
					a.setMetadata("93", new FixedMetadataValue(this, 0));
				}
				if(abilities.contains(119)) {
					ability119.add(a);
					a.setMetadata("119", new FixedMetadataValue(this, 0));
				}
				if(abilities.contains(120)) {
					ability120.add(a);
					a.setMetadata("120", new FixedMetadataValue(this, 0));
				}
				if(abilities.contains(121)) {
					ability121.add(a);
					a.setMetadata("121", new FixedMetadataValue(this, 0));
				}
				if(abilities.contains(94)) {
					a.setMetadata("94", new FixedMetadataValue(this, "" + p.getName()));
				}
				if(abilities.contains(129)) {
					a.setMetadata("129", new FixedMetadataValue(this, "" + p.getName()));
				}
				if(abilities.contains(95)) {
					a.setMetadata("95", new FixedMetadataValue(this, "" + p.getName()));
				}
				if(abilities.contains(133)) {
					a.setMetadata("133", new FixedMetadataValue(this, "" + p.getName()));
				}
				if(abilities.contains(131)) {
					a.setMetadata("131", new FixedMetadataValue(this, 0));
					ability131.add(a);
				}
				if(abilities.contains(96)) {
					a.setMetadata("96", new FixedMetadataValue(this, 0));
				}
				if(abilities.contains(97)) {
					ability97.add(a);
					a.setMetadata("97", new FixedMetadataValue(this, 0));
				}
				if(abilities.contains(113)) {
					ability113.add(a);
					a.setMetadata("113", new FixedMetadataValue(this, 0));
				}
				if(abilities.contains(98)) {
					if(a instanceof Arrow) {
						v.multiply(2);
						a.setGravity(false);
						ability98.add(a);
						a.setMetadata("98", new FixedMetadataValue(this, 0));
					}
				}
				if(abilities.contains(102)) {
					a.setMetadata("102", new FixedMetadataValue(this, 0));
				}
				if(abilities.contains(104)) {
					ability104.add(a);
					a.setMetadata("104", new FixedMetadataValue(this, 0));
				}
				if(abilities.contains(115)) {
					ability115.add(a);
					a.setMetadata("115", new FixedMetadataValue(this, 0));
				}
				if(abilities.contains(105)) {
					a.setMetadata("105", new FixedMetadataValue(this, 0));
				}
				if(abilities.contains(110) && iteration == 0) {
					ability110.add(a);
					a.setMetadata("110", new FixedMetadataValue(this, "" + p.getName()));
				}
				if(abilities.contains(114)) {
					if(a instanceof Arrow) {
						((Arrow) a).setKnockbackStrength((((Arrow) a).getKnockbackStrength()+1)*2);
					}
				}
				if(abilities.contains(111) && iteration == 0) {
					ability111.add(a);
					a.setMetadata("111", new FixedMetadataValue(this, "" + p.getName()));
				}
				if(abilities.contains(112)) {
					a.setMetadata("112", new FixedMetadataValue(this, "" + p.getName()));
				}
				if(abilities.contains(130)) {
					if(p.getLocation().add(0, 1.2, 0).getBlock().getType().name().toLowerCase().contains("water")) {
						v.multiply(2.5);
						a.setMetadata("130", new FixedMetadataValue(this, 0));
						ability130.add(a);
					}
				}
				if(a instanceof Arrow) {
					((Arrow) a).setPickupStatus(org.bukkit.entity.AbstractArrow.PickupStatus.DISALLOWED);
				}
				a.setMetadata("playershoot", new FixedMetadataValue(this, "" + p.getName()));
				if(iteration == 0) {
					finalv = v.clone();
					a.setVelocity(v);
				}
				else {
					if(abilities.contains(106)) {
						a.setVelocity(finalv.clone().add(new Vector(coinFlip()*randor.nextInt(99)/700.0,coinFlip()*randor.nextInt(99)/700.0,coinFlip()*randor.nextInt(99)/700.0)));
					}
					else {
					a.setVelocity(finalv);
					}
				}
				}
			}
		}
		
		@EventHandler
		public void onPlayerPickupExperience(EntityPickupItemEvent e) {
			if(notnpc(e.getEntity())) {
				ItemStack item = e.getItem().getItemStack();
				if(hasLore(item, "experience")) {
					e.setCancelled(true);
					((Player) e.getEntity()).setLevel(((Player) e.getEntity()).getLevel() + 1);
					e.getItem().remove();
				}
			}
		}
		
		@EventHandler
		public void arrowHitEvent(ProjectileHitEvent e) {
			if(e.getEntity() instanceof Projectile) {
				Projectile a = (Projectile) e.getEntity();
				if(e.getHitBlock() != null) {
					boolean deletearrow = false;
					if(a.hasMetadata("85")) {
						if(isBlockNotSolid(e.getHitBlock().getRelative(BlockFace.UP))) {
							e.getHitBlock().getRelative(BlockFace.UP).setType(Material.FIRE);
						}
					}
					if(a.hasMetadata("84")) {
						ability84.remove(a);
					}
					if(a.hasMetadata("97")) {
						ability97.remove(a);
					}
					if(a.hasMetadata("131")) {
						ability131.remove(a);
					}
					if(a.hasMetadata("93")) {
						ability93.remove(a);
					}
					if(a.hasMetadata("98")) {
						ability98.remove(a);
					}
					if(a.hasMetadata("104")) {
						ability104.remove(a);
					}
					if(a.hasMetadata("130")) {
						ability130.remove(a);
					}
					if(a.hasMetadata("132")) {
						ability132.remove(a);
					}
					if(a.hasMetadata("105m")) {
						deletearrow = true;
					}
					if(a.hasMetadata("104")) {
						ability104.remove(a);
					}
					if(a.hasMetadata("102")) {
						Block b = e.getHitBlock();
						b.getWorld().playSound(b.getLocation(), bs.getBreakSound(b.getType()+""), 1, 1);
						Material mtype = b.getType();
						b.setType(Material.AIR);
						for(int count = 0; count < 30; count++) {
							b.getWorld().spawnParticle(Particle.BLOCK_CRACK, ((double) b.getX())+(randor.nextInt(100)/100.0), ((double) b.getY())+(randor.nextInt(100)/100.0), ((double) b.getZ())+(randor.nextInt(100)/100.0), 1, new MaterialData(mtype));
						}
						deletearrow = true;
					}
					if(a.hasMetadata("89")) {
						Location start = a.getLocation().clone();
						a.getWorld().strikeLightning(start);
						HashMap<Integer, List<Block>> empty = new HashMap<Integer, List<Block>>();
						for(int count = 0; count < 10; count++) {
						Location end = getRandLoc(start.clone(), 1);
						double step = 0.05D;

						Vector line = end.toVector().subtract(start.toVector());
						for (double d = 0; d < line.length()/2.0; d += step) {
							final double dd = d;
							Location l = start.clone().add(line.clone().multiply(dd));
							Bukkit.getScheduler().runTaskLater(this, () ->  a.getWorld().spawnParticle(Particle.LAVA, l, 1, 0, 0, 0, 0.05), (long) (1*(d*5)));
						}
						}
						ability89.remove(a);
						deletearrow = true;
					}
					if(a.hasMetadata("110")) {
						ability110.remove(a);
						deletearrow = true;
					}
					if(a.hasMetadata("119")) {
						ability119.remove(a);
					}
					if(a.hasMetadata("120")) {
						ability120.remove(a);
					}
					if(a.hasMetadata("121")) {
						ability121.remove(a);
					}
					if(a.hasMetadata("115")) {
						ability115.remove(a);
					}
					if(a.hasMetadata("113")) {
						ability113.remove(a);
						createSlimePit(e.getHitBlock().getLocation());
						deletearrow = true;
					}
					if(a.hasMetadata("111")) {
						ability111.remove(a);
						Location l = e.getHitBlock().getLocation().add(0, 1, 0);
						if(isBlockNotSolid(l.getBlock())) {
							l.add(0, 1, 0);
							if(isBlockNotSolid(l.getBlock())) {
								if(a.getMetadata("111").size()>0) {
									Player p = Bukkit.getPlayer(a.getMetadata("111").get(0).asString());
									p.teleport(l);
									p.getWorld().playSound(l, Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
									p.getWorld().spawnParticle(Particle.SPELL_WITCH, l.subtract(0, 1, 0), 25, 0.4, 1, 0.4, 0.0001);
								}
							}
						}
						deletearrow = true;
					}
					if(a.hasMetadata("96")) {
						Location l1 = e.getHitBlock().getLocation().add(0, 1, 0);
						Location l2 = e.getHitBlock().getLocation().add(0, 2, 0);
						Location l3 = e.getHitBlock().getLocation().add(1, 1, 0);
						Location l4 = e.getHitBlock().getLocation().add(0, 1, 1);
						Location l5 = e.getHitBlock().getLocation().add(-1, 1, 0);
						Location l6 = e.getHitBlock().getLocation().add(0, 1, -1);
						Location l7 = e.getHitBlock().getLocation();
						if(isBlockNotSolid(l1.getBlock())) {
							Bukkit.getScheduler().runTaskLater(this, () ->  l1.getBlock().setType(Material.COBWEB), 1);
							Bukkit.getScheduler().runTaskLater(this, () ->  l1.getWorld().spawnParticle(Particle.CLOUD, l1.add(0.5, 0.5, 0.5), 20, 0, 0, 0, 0.05), 1);
						}
						if(isBlockNotSolid(l2.getBlock())) {
							Bukkit.getScheduler().runTaskLater(this, () ->  l2.getBlock().setType(Material.COBWEB), 5);
							Bukkit.getScheduler().runTaskLater(this, () ->  l2.getWorld().spawnParticle(Particle.CLOUD, l2.add(0.5, 0.5, 0.5), 20, 0, 0, 0, 0.05), 5);
						}
						if(isBlockNotSolid(l3.getBlock())) {
							Bukkit.getScheduler().runTaskLater(this, () ->  l3.getBlock().setType(Material.COBWEB), 10);
							Bukkit.getScheduler().runTaskLater(this, () ->  l3.getWorld().spawnParticle(Particle.CLOUD, l3.add(0.5, 0.5, 0.5), 20, 0, 0, 0, 0.05), 10);
						}
						if(isBlockNotSolid(l4.getBlock())) {
							Bukkit.getScheduler().runTaskLater(this, () ->  l4.getBlock().setType(Material.COBWEB), 15);
							Bukkit.getScheduler().runTaskLater(this, () ->  l4.getWorld().spawnParticle(Particle.CLOUD, l4.add(0.5, 0.5, 0.5), 20, 0, 0, 0, 0.05), 15);
						}
						if(isBlockNotSolid(l5.getBlock())) {
							Bukkit.getScheduler().runTaskLater(this, () ->  l5.getBlock().setType(Material.COBWEB), 20);
							Bukkit.getScheduler().runTaskLater(this, () ->  l5.getWorld().spawnParticle(Particle.CLOUD, l5.add(0.5, 0.5, 0.5), 20, 0, 0, 0, 0.05), 20);
						}
						if(isBlockNotSolid(l6.getBlock())) {
							Bukkit.getScheduler().runTaskLater(this, () ->  l6.getBlock().setType(Material.COBWEB), 25);
							Bukkit.getScheduler().runTaskLater(this, () ->  l6.getWorld().spawnParticle(Particle.CLOUD, l6.add(0.5, 0.5, 0.5), 20, 0, 0, 0, 0.05), 25);
						}
						if(isBlockNotSolid(l7.getBlock())) {
							Bukkit.getScheduler().runTaskLater(this, () ->  l7.getBlock().setType(Material.COBWEB), 30);
							Bukkit.getScheduler().runTaskLater(this, () ->  l7.getWorld().spawnParticle(Particle.CLOUD, l7.add(0.5, 0.5, 0.5), 20, 0, 0, 0, 0.05), 30);
						}
						deletearrow = true;
					}
					if(a.hasMetadata("105")) {
						explodeArrow(a.getLocation().getBlock().getLocation().add(.5, .5, .5).clone());
						deletearrow = true;
					}
					if(deletearrow) {
						a.remove();
					}
				}
				else if(e.getHitEntity() != null) {
					if(a.hasMetadata("94")) {
					doHeadshotCalculate(e.getEntity(), e.getHitEntity());
					}
					if(a.hasMetadata("105")) {
						Bukkit.getScheduler().runTaskLater(this, () ->  explodeArrow(a.getLocation().getBlock().getLocation().add(.5, .5, .5).clone()), 1);
						Bukkit.getScheduler().runTaskLater(this, () ->  a.remove(), 2);
					}
				}
			}
		}
		
		public void explodeArrow(Location l) {
			l.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, l, 1);
			l.getWorld().playSound(l, Sound.ENTITY_GENERIC_EXPLODE, 1, 2);
			for(int count = 0; count < 20; count++) {
				Arrow a = (Arrow) l.getWorld().spawnEntity(l, EntityType.ARROW);
				a.setPickupStatus(org.bukkit.entity.AbstractArrow.PickupStatus.DISALLOWED);
				a.setMetadata("105m", new FixedMetadataValue(this, 0));
				Vector v = getRandLoc(l, 2).toVector().subtract(a.getLocation().toVector()).normalize();
				a.setVelocity(v);
			}
		}
		
		@EventHandler
		public void entityHitByArrow(EntityDamageByEntityEvent e) {
			if(!e.isCancelled()) {
				if(e.getEntity() instanceof LivingEntity && e.getDamager() instanceof Projectile) {
					if(notnpc(e.getEntity())) {
						if(e.getDamager().hasMetadata(((Player) e.getEntity()).getName())){
							e.setCancelled(true);
							return;
						}
					}
					LivingEntity le = (LivingEntity) e.getEntity();
					boolean removearrow = false;
					Projectile a = (Projectile) e.getDamager();
					if(a.hasMetadata("110")) {
						ability110.remove(a);
					}
					if(a.hasMetadata("111")) {
						ability111.remove(a);
						Location l = getRandLoc(le.getLocation().add(0, 1, 0), 1);
						le.teleport(l);
						le.getWorld().playSound(l, Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
						le.getWorld().spawnParticle(Particle.SPELL_WITCH, l, 25, 0.4, 1, 0.4, 0.0001);
					}
					if(a.hasMetadata("84")) {
						addPotionEffectBetter(le, PotionEffectType.GLOWING, 100, 0, false, false, false);
						ability84.remove(a);
					}
					if(a.hasMetadata("131")) {
						if(randor.nextInt(20)==1) {
						addPotionEffectBetter(le, PotionEffectType.SLOW, 999999, 1, false, false, false);
						}
						ability131.remove(a);
					}
					if(a.hasMetadata("85")) {
						le.setFireTicks(85);
						ability85.remove(a);
					}
					if(a.hasMetadata("98")) {
						ability98.remove(a);
					}
					if(a.hasMetadata("93")) {
						ability93.remove(a);
					}
					if(a.hasMetadata("113")) {
						ability113.remove(a);
					}
					if(a.hasMetadata("104")) {
						ability104.remove(a);
					}
					if(a.hasMetadata("130")) {
						ability130.remove(a);
					}
					if(a.hasMetadata("119")) {
						addPotionEffectBetter(le, PotionEffectType.POISON, 100, 1, false, false, false);
						ability119.remove(a);
					}
					if(a.hasMetadata("132")) {
						addPotionEffectBetter(le, PotionEffectType.SPEED, 50, 100, false, false, false);
						ability132.remove(a);
					}
					if(a.hasMetadata("120")) {
						if(e instanceof Monster) {
							addPotionEffectBetter(le, PotionEffectType.HEAL, 2, 1, false, false, false);
						}
						else {
							addPotionEffectBetter(le, PotionEffectType.HARM, 2, 1, false, false, false);
						}
						ability120.remove(a);
					}
					if(a.hasMetadata("121")) {
						addPotionEffectBetter(le, PotionEffectType.SLOW, 100, 1, false, false, false);
						ability121.remove(a);
					}
					if(a.hasMetadata("112")) {
						Player p = null;
						if(a.getMetadata("112").size()>0) {
							p = Bukkit.getPlayer(a.getMetadata("112").get(0).asString());
						}
						doBleed(le, 0, p);
					}
					if(a.hasMetadata("115")) {
						le.getWorld().playSound(le.getLocation(), Sound.ENTITY_HORSE_BREATHE, 1, (float) 0.7);
						Bukkit.getScheduler().runTaskLater(this, () ->  le.setVelocity(le.getVelocity().add(new Vector(0, 2, 0))), (long) 2);
						ability115.remove(a);
						
					}
					if(a.hasMetadata("107")) {
						if(le instanceof Player) {
							removeLeather(le);
						}
					}
					if(a.hasMetadata("129")) {
						if(a.getMetadata("129").size()>0) {
							Player attacker = Bukkit.getPlayer(a.getMetadata("129").get(0).asString());
							if(attacker != null) {
								Vector v = attacker.getLocation().toVector().subtract(le.getLocation().toVector()).normalize().multiply(3.2);
								le.setVelocity(v);
								le.getWorld().playSound(le.getLocation(), Sound.ENTITY_FISHING_BOBBER_THROW, 1, 1);
							}
						}
						else {
							
						}
					}
					if(a.hasMetadata("95")) {
						if(a.getMetadata("95").size()>0) {
							Player attacker = Bukkit.getPlayer(a.getMetadata("95").get(0).asString());
							if(attacker == null) {
								
							}
							else {
								healPlayer(attacker, 1);
							}
						}
						else {
							
						}
					}
					if(a.hasMetadata("133")) {
						if(a.getMetadata("133").size()>0) {
							Player attacker = Bukkit.getPlayer(a.getMetadata("133").get(0).asString());
							if(attacker == null) {
								
							}
							else {
								attacker.getWorld().playSound(attacker.getLocation(), Sound.ENTITY_GENERIC_EAT, 1, 1);
								feedPlayer(attacker, 1);
							}
						}
						else {
							
						}
					}
					if(a.hasMetadata("89")) {
						Location start = le.getLocation().clone();
						a.getWorld().strikeLightning(start);
						HashMap<Integer, List<Block>> empty = new HashMap<Integer, List<Block>>();
						for(int count = 0; count < 10; count++) {
						Location end = getRandLoc(start.clone(), 1);
						double step = 0.05D;

						Vector line = end.toVector().subtract(start.toVector());
						for (double d = 0; d < line.length()/2.0; d += step) {
							final double dd = d;
							Location l = start.clone().add(line.clone().multiply(dd));
							Bukkit.getScheduler().runTaskLater(this, () ->  a.getWorld().spawnParticle(Particle.LAVA, l, 1, 0, 0, 0, 0.05), (long) (1*(d*5)));
						}
						}
						ability89.remove(a);
						removearrow = true;
					}
					if(a.hasMetadata("97")) {
						le.getWorld().playSound(le.getLocation(), Sound.BLOCK_LAVA_POP, 1, 2);
						le.getWorld().spawnParticle(Particle.WATER_SPLASH, le.getLocation().add(0, 1, 0), 25, 0.5, 1, 0.5, 0.0001);
						if(le instanceof Player) {
							Player p = (Player) le;
							if(p.getLevel()>=1) {
							p.setLevel(p.getLevel() - 1);
							ItemStack exp = new ItemStack(Material.LIME_DYE);
							ItemMeta im = exp.getItemMeta();
							im.setLore(Arrays.asList("experience", "" + randor.nextInt(99)));
							im.setDisplayName("experience");
							exp.setItemMeta(im);
							Item item = p.getWorld().dropItemNaturally(p.getLocation().add(0, 1, 0), exp);
							item.setPickupDelay(30);
							}
						}
						ability97.remove(a);
					}
					if(removearrow == true) {
						a.remove();
					}
				}
			}
		}
		
		public void removeLeather(LivingEntity le) {
			boolean removedleather = false;
			PlayerInventory i = ((Player) le).getInventory();
			if(i.getHelmet()!=null) {
				if(i.getHelmet().getType() == Material.LEATHER_HELMET) {
					if(randor.nextInt(3)==1) {
						ItemStack helmet = ((Player) le).getInventory().getHelmet();
						Item item = le.getWorld().dropItemNaturally(le.getLocation().add(0, 2, 0), helmet);
						item.setPickupDelay(30);
						removedleather = true;
					}
				}
			}
			if(removedleather==false) {
				if(i.getChestplate()!=null) {
					if(i.getChestplate().getType() == Material.LEATHER_CHESTPLATE) {
						if(randor.nextInt(3)==1) {
							ItemStack chest = ((Player) le).getInventory().getChestplate();
							Item item = le.getWorld().dropItemNaturally(le.getLocation().add(0, 1, 0), chest);
							item.setPickupDelay(30);
							removedleather = true;
						}
					}
				}
			}
			if(removedleather==false) {
				if(i.getLeggings()!=null) {
					if(i.getLeggings().getType() == Material.LEATHER_LEGGINGS) {
						if(randor.nextInt(3)==1) {
							ItemStack leg = ((Player) le).getInventory().getLeggings();
							Item item = le.getWorld().dropItemNaturally(le.getLocation().add(0, 1, 0), leg);
							item.setPickupDelay(30);
							removedleather = true;
						}
					}
				}
			}
			if(removedleather==false) {
				if(i.getBoots()!=null) {
					if(i.getBoots().getType() == Material.LEATHER_BOOTS) {
						if(randor.nextInt(3)==1) {
							ItemStack boot = ((Player) le).getInventory().getBoots();
							Item item = le.getWorld().dropItemNaturally(le.getLocation().add(0, .2, 0), boot);
							item.setPickupDelay(30);
							removedleather = true;
						}
					}
				}
			}
			if(removedleather) {
				le.getWorld().playSound(le.getLocation(), Sound.ITEM_ARMOR_EQUIP_LEATHER, 1, 0);
			}
		}
		
		public void doHeadshotCalculate(Projectile a, Entity hit) {
			if(hit!=null) {
				if(a instanceof Projectile) {
					if(hit instanceof LivingEntity) {
						LivingEntity enti = (LivingEntity) hit;
						if(enti instanceof Player||enti instanceof Monster) {
							if(a.getLocation().getY()>enti.getLocation().getY()+1.35) {
								Player p2 = Bukkit.getPlayer(a.getMetadata("94").get(0).asString());
								if(p2 == null) {
									return;
								}
								if(!(enti instanceof Player)) {
									damageNonCharacter(enti, 12, p2);
								}
								else {
									double damag = 12;
									Player p = (Player) enti;
									if(shopGUIS.enabled.get(p.getName()).contains(33)) {
										return;
									}
									if(p.getInventory().getHelmet()!=null) {
										if(p.getInventory().getHelmet().getType()==Material.LEATHER_HELMET) {
											damag = damag - 3;
										}
										else if(p.getInventory().getHelmet().getType()==Material.DIAMOND_HELMET) {
											damag = damag - 6;
											p.getWorld().playSound(new Location(p.getWorld(), enti.getLocation().getX(), enti.getLocation().getY()+1.35, enti.getLocation().getZ()), Sound.BLOCK_ANVIL_LAND, 1, 1);
											p.getWorld().spawnParticle(Particle.BLOCK_CRACK, enti.getLocation().getX(), enti.getLocation().getY()+1.35, enti.getLocation().getZ(), 25, Material.DIAMOND_BLOCK.createBlockData());
										}
										else if(p.getInventory().getHelmet().getType()==Material.GOLDEN_HELMET) {
											damag = damag - 4;
											p.getWorld().playSound(new Location(p.getWorld(), enti.getLocation().getX(), enti.getLocation().getY()+1.35, enti.getLocation().getZ()), Sound.BLOCK_ANVIL_LAND, 1, 1);
											p.getWorld().spawnParticle(Particle.BLOCK_CRACK, enti.getLocation().getX(), enti.getLocation().getY()+1.35, enti.getLocation().getZ(), 25, Material.GOLD_BLOCK.createBlockData());
										}
										else if(p.getInventory().getHelmet().getType()==Material.IRON_HELMET || p.getInventory().getHelmet().getType()==Material.CHAINMAIL_HELMET) {
											damag = damag - 5;
											p.getWorld().playSound(new Location(p.getWorld(), enti.getLocation().getX(), enti.getLocation().getY()+1.35, enti.getLocation().getZ()), Sound.BLOCK_ANVIL_LAND, 1, 1);
											p.getWorld().spawnParticle(Particle.BLOCK_CRACK, enti.getLocation().getX(), enti.getLocation().getY()+1.35, enti.getLocation().getZ(), 25, Material.IRON_BLOCK.createBlockData());
										}	
										if(shopGUIS.enabled.get(p.getName()).contains(25)) {
											damag = damag / 2.0;
										}
										damagePlayerReasonPlayer(p, damag, "final", p2);
									}
									else {
										if(shopGUIS.enabled.get(p.getName()).contains(25)) {
											damagePlayerReasonPlayer(p, 6, "final", p2);
										}
										else {
										damagePlayerReasonPlayer(p, 12, "final", p2);
										}
									}
								}
								if(!(enti instanceof Zombie||enti instanceof Skeleton||enti instanceof Creeper||enti instanceof Stray)) {
									enti.getWorld().playSound(new Location(enti.getWorld(), enti.getLocation().getX(), enti.getLocation().getY()+1.35, enti.getLocation().getZ()), Sound.ENTITY_GUARDIAN_FLOP, 1, 1);
									enti.getWorld().spawnParticle(Particle.BLOCK_CRACK, enti.getLocation().getX(), enti.getLocation().getY()+1.35, enti.getLocation().getZ(), 25, Material.NETHER_WART_BLOCK.createBlockData());
								}
								else if(enti instanceof Zombie||enti instanceof Creeper) {
									enti.getWorld().playSound(new Location(enti.getWorld(), enti.getLocation().getX(), enti.getLocation().getY()+1.35, enti.getLocation().getZ()), Sound.ENTITY_GUARDIAN_FLOP, 1, 1);
									enti.getWorld().spawnParticle(Particle.BLOCK_CRACK, enti.getLocation().getX(), enti.getLocation().getY()+1.35, enti.getLocation().getZ(), 25, Material.GREEN_SHULKER_BOX.createBlockData());
								}
								else if(enti instanceof Skeleton||enti instanceof Stray) {
									enti.getWorld().playSound(new Location(enti.getWorld(), enti.getLocation().getX(), enti.getLocation().getY()+1.35, enti.getLocation().getZ()), Sound.ENTITY_SKELETON_AMBIENT, 1, 1);
									enti.getWorld().spawnParticle(Particle.BLOCK_CRACK, enti.getLocation().getX(), enti.getLocation().getY()+1.35, enti.getLocation().getZ(), 25, Material.BONE_BLOCK.createBlockData());
								}
								enti.setVelocity(new Vector(0,0,0));
								enti.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 80, 100, false, false));
								a.remove();
								p2.playSound(p2.getLocation(), Sound.BLOCK_NOTE_BLOCK_SNARE, (float) 1, (float) 1.2);
							}
						}
					}
				}
			}
		}
		
		public void doBleed(LivingEntity e, int count, Player p) {
			if(count<(4+randor.nextInt(3))) {
				if(e != null) {
					if(e.isDead()) {
						return;
					}
				e.getWorld().playSound(e.getLocation(), Sound.ENTITY_GUARDIAN_FLOP, 1, 1);
				for(int space = 0; space < 25; space++) {
				e.getWorld().spawnParticle(Particle.BLOCK_CRACK, e.getLocation().getX()+(coinFlip()*(randor.nextInt(500)/1000.0)), (e.getLocation().getY() + 1)+(coinFlip()*(randor.nextInt(1000)/1000.0)), e.getLocation().getZ()+(coinFlip()*(randor.nextInt(500)/1000.0)), 1, Material.NETHER_WART_BLOCK.createBlockData());
				}
				if(e instanceof Player) {
					if(p != null) {
						damagePlayerReasonPlayer(((Player) e), 1, "deal", p);
					}
					else {
						damagePlayerReason(((Player) e), 1, "deal");
					}
				}
				else {
					damageNonCharacter(e, 1, p);
				}
				Bukkit.getScheduler().runTaskLater(this, () ->  doBleed(e, count+1, p), (long) (count*25));
				}
				else {
					return;
				}
			}
			else {
				return;
			}
		}
		
		public boolean isBlockNotSolid(Block b) {
			if(b.isPassable()||isAir(Material.AIR)||b.getType()==Material.GRASS||b.getType()==Material.TALL_GRASS) {
				return true;
			}
			return false;
		}
		
		public void createSlimePit(Location l) {
			l.getWorld().playSound(l, Sound.ENTITY_SLIME_SQUISH, 1, (float) 0.5); 
			Location loc = l.clone();
	    	int radius = 3;
	    		int cx = loc.getBlockX();
	    		int cy = loc.getBlockY();
	    		int cz = loc.getBlockZ();
	    		for(int x = cx - radius; x <= cx + radius; x++){
	    			for (int z = cz - radius; z <= cz + radius; z++){
	    				for(int y = (cy - radius); y < (cy + radius); y++){
	    				double dist = (cx - x) * (cx - x) + (cz - z) * (cz - z) + ((cy - y) * (cy - y));

	    				if(dist < radius * radius){
	    					Location l2 = new Location(loc.getWorld(), x, y + 2, z);
	    					if(isBlockNotSolid(l2.clone().add(0, 1, 0).getBlock())&&(!isBlockNotSolid(l2.getBlock()))) {
	    						l2.getWorld().spawnParticle(Particle.SLIME, l2.getBlock().getLocation().add(0.5, 1.1, 0.5), 7, 0.5, 0, 0.5, 0.0001);
	    						l2.getBlock().setType(Material.SLIME_BLOCK);
	    					}
	    				}
	    		
	    				}
	    			}
	    		}
		}

		@EventHandler
		public void onPlayerMoveSlime(PlayerMoveEvent e) {
				Location to = e.getTo();
				Location from = e.getFrom();
				if(!(((int)from.getX()==(int)to.getX())&&((int)from.getY()==(int)to.getY())&&((int)from.getZ()==(int)to.getZ()))) {
					//if(to.clone().subtract(0, 1, 0).getBlock().getType()==Material.SLIME_BLOCK) {
					//	addPotionEffectBetter(e.getPlayer(), PotionEffectType.SLOW, 200, 1, false, false, false);
					//}
					if(!notnpc(e.getPlayer())) {
						return;
					}
					if(!shopGUIS.enabled.containsKey(e.getPlayer().getName())) {
						return;
					}
					fireWalk(e.getPlayer(), e.getFrom());
				}
		}
		
		public void onDissapear() {
			
		}
		
		//
		
		//Player Abilities
		
		List<Entity> ability150 = new ArrayList<Entity>();
		List<Entity> ability152 = new ArrayList<Entity>();

		public boolean canHuman(Entity e) {
			if(e == null) {
				return false;
			}
			if(e.isDead()) {
				return false;
			}
			return true;
		}
		
		public void playerEffects() {
			ArrayList<Entity> ability150c = new ArrayList<Entity>(ability150);
			boolean isDay = true;
			boolean isDayChecked = false;
			for(Entity e : ability150c) {
				if(canHuman(e)) {
					if(isDayChecked == false) {
						if((e.getWorld().getTime()>12500&&e.getWorld().getTime()<22900)) {
							isDay = false;
						}
						isDayChecked = false;
					}
					if(isDay) {
						Location l = e.getLocation();
						if(l.getBlock().getLightFromSky()>3) {
							if(randor.nextInt(10)==1) {
							damagePlayerReason(((Player) e), 2, "deal");
							((Player) e).setFireTicks(100);
							e.getWorld().spawnParticle(Particle.FLAME, l.clone().add(0, 1.35, 0), 5, 0.2, 0.2, 0.2, 0.05);
							e.getWorld().spawnParticle(Particle.SMOKE_NORMAL, l.clone().add(0, 1.35, 0), 20, 0.2, 0.2, 0.2, 0.05);
							}
						}
					}
				}
				else {
					ability150.remove(e);
				}
			}
			ArrayList<Entity> ability152c = new ArrayList<Entity>(ability152);
			for(Entity e : ability152c) {
				if(canHuman(e)) {
					if(((Player) e).getHealth()<6) {
						ItemStack itemData = new ItemStack(Material.EGG);
				        e.getWorld().spawnParticle(Particle.ITEM_CRACK, e.getLocation().clone().add(0, 1, 0), 6, 0.3, 0.5, 0.3, 0.001, itemData);
					}
				}
				else {
					ability152.remove(e);
				}
			}
		}
		
		@EventHandler
		public void checkEnabledAbiltiesOnJoinP(PlayerJoinEvent e) {
			if(artifactsE) {
			Player p = e.getPlayer();
			if(shopGUIS.enabled.containsKey(e.getPlayer().getName())) {
			List<Integer> abilities = shopGUIS.enabled.get(e.getPlayer().getName());
			passiveJoin(p, shopGUIS.enabled.get(e.getPlayer().getName()));
			if(abilities.contains(147)) {
				if(playertimes.containsKey(p.getName())) {
					for(String disctype : discnames.keySet()) {
						p.stopSound(Sound.valueOf("MUSIC_DISC_" + disctype.toUpperCase()));
					}
					playertimes.put(p.getName(), 0);
					p.playSound(p.getLocation(), Sound.valueOf("MUSIC_DISC_" + discs.get(p)), 100, pitches.get(p));
					p.sendMessage(ChatColor.LIGHT_PURPLE + "Track " + discs.get(p) + " at pitch " + pitches.get(p) + " has been started on the radio.");
					p.sendMessage(ChatColor.LIGHT_PURPLE + "Thank you for using the radio today!");
				}
			}
			if(abilities.contains(150)) {
				if(!ability150.contains(p)) {
					ability150.add(p);
				}
			}
			if(abilities.contains(152)) {
				if(!ability152.contains(p)) {
					ability152.add(p);
				}
			}
			}
			}
		}
		
		public void enabledAbilityP(int abilnum, Player p) {
			if(abilnum == 150) {
				ability150.add(p);
			}
			if(abilnum == 152) {
				ability152.add(p);
			}
			passiveEnable(p, abilnum);
		}
		
		public void disabledAbilityP(int abilnum, Player p) {
			if(abilnum == 147) {
				if(playertimes.containsKey(p.getName())) {
					playertimes.remove(p.getName());
					discs.remove(p);
					pitches.remove(p);
				}
				for(String disctype : discnames.keySet()) {
					p.stopSound(Sound.valueOf("MUSIC_DISC_" + disctype.toUpperCase()));
				}
				p.sendMessage(ChatColor.LIGHT_PURPLE + "Stopped your radio!");
			}
			if(abilnum == 150) {
				ability150.remove(p);
			}
			if(abilnum == 152) {
				ability152.remove(p);
			}
			passiveDisable(p, abilnum);
		}
		
		@EventHandler
		public void onPlayerHitWithHand(PlayerInteractEvent e) {
				Player p = e.getPlayer();
				if(!notnpc(p)) {
					return;
				}
				if(!shopGUIS.enabled.containsKey(p.getName())) {
					return;
				}
					if(e.getAction() == Action.LEFT_CLICK_AIR) {
						if(shopGUIS.enabled.get(p.getName()).contains(143)) {
							if(p.getInventory().getItemInMainHand()==null) {
								p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDER_PEARL_THROW, 1, 1);
								EnderPearl a2 = (EnderPearl) p.launchProjectile(EnderPearl.class);
								a2.setVelocity(p.getLocation().getDirection().normalize());
								a2.setShooter(p);
							}
							else if(p.getInventory().getItemInMainHand().getType()==Material.AIR) {
								p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDER_PEARL_THROW, 1, 1);
								EnderPearl a2 = (EnderPearl) p.launchProjectile(EnderPearl.class);
								a2.setVelocity(p.getLocation().getDirection().normalize());
								a2.setShooter(p);
							}
						}
					}
		}
		
		@EventHandler
		public void onPlayerTeleportEnderpearl(PlayerTeleportEvent e) {
			if(e.getCause() == TeleportCause.ENDER_PEARL) {
				if(notnpc(e.getPlayer())) {
			if(shopGUIS.enabled.containsKey(e.getPlayer().getName())) {
			if(shopGUIS.enabled.get(e.getPlayer().getName()).contains(143)) {
				if(e.getFrom().distance(e.getTo())>10) {
					e.setCancelled(true);
				}
			}
			}
			}
			}
		}
		
		@EventHandler
		public void silverfishTarget(EntityTargetEvent e) {
			if(e.getTarget() instanceof Player && e.getEntity() instanceof Monster) {
				String playername = ((Player) e.getTarget()).getName();
				if(e.getEntity().hasMetadata(playername)) {
					e.setCancelled(true);
				}
			}
		}
		
		@EventHandler
		public void entityHitByPlayer(EntityDamageByEntityEvent e) {
			if(!e.isCancelled()) {
				if(e.getEntity() instanceof LivingEntity && notnpc(e.getDamager())) {
					LivingEntity le = (LivingEntity) e.getEntity();
					Player p = (Player) e.getDamager();
					if(!shopGUIS.enabled.containsKey(p.getName())) {
						return;
					}
					if(shopGUIS.enabled.get(p.getName()).contains(139)) {
						if(randor.nextInt(6)==0) {
							le.getWorld().playSound(le.getLocation(), Sound.BLOCK_LEVER_CLICK, 1, 2);
							le.getWorld().spawnParticle(Particle.BLOCK_CRACK, le.getLocation().getX(), le.getLocation().getY()+((randor.nextInt(13)+1)/10.0), le.getLocation().getZ(), 20, Material.BONE_BLOCK.createBlockData());
							addPotionEffectBetter(le, PotionEffectType.SLOW, 100, 1, false, false, false);
						}
					}
					if(shopGUIS.enabled.get(p.getName()).contains(158)) {
						if(randor.nextInt(16)==0) {
							if(le instanceof Monster || le instanceof Player) {
							if(!(getLookingAt(le, p, (float) .5))) {
								ItemStack main = le.getEquipment().getItemInMainHand();
								ItemStack off = le.getEquipment().getItemInOffHand();
								if(main != null) {
								if(le instanceof Monster) {
									le.getWorld().dropItemNaturally(le.getLocation().add(0, 1, 0), main);
									le.getEquipment().setItemInMainHand(new ItemStack(Material.AIR));
								}
								else {
									((Player) le).sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Disarmed!");
									ItemStack mainc = main.clone();
									if(off != null) {
										le.getEquipment().setItemInMainHand(off);
									}
									le.getEquipment().setItemInOffHand(mainc);
								}
								}
							}
							}
						}
					}
					if(le instanceof Player) {
						Player p2 = ((Player) le);
						if(shopGUIS.enabled.get(p2.getName()).contains(140)) {
							if(randor.nextInt(8)==1) {
							p2.getWorld().playSound(p2.getLocation(), Sound.ENTITY_SILVERFISH_AMBIENT, 1, (float) 1.2);
							le.getWorld().spawnParticle(Particle.BLOCK_CRACK, le.getLocation().getX(), le.getLocation().getY()+.1, le.getLocation().getZ(), 15, Material.STONE.createBlockData());
							LivingEntity silver = (LivingEntity) p2.getWorld().spawnEntity(p2.getLocation().add(0, 0.1, 0), EntityType.SILVERFISH);
							silver.setMetadata("" + p2.getName(), new FixedMetadataValue(this, 0));
							addPotionEffectBetter(silver, PotionEffectType.SPEED, 999999, 3, false, false, false);
							silver.setCustomName(ChatColor.RED + "" + ChatColor.BOLD + "" + p2.getName() + "'s Crazy Ant");
							}
						}
					}
				}
				if(e.getEntity() instanceof Player && e.getDamager() instanceof LivingEntity) {
					Player p = (Player) e.getEntity();
					if(shopGUIS.enabled.get(p.getName()).contains(151)) {
							LivingEntity attacker = (LivingEntity) e.getDamager();
							if(attacker != null) {
								if(attacker.getHealth()==attacker.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()) {
									Location b = getBlockBehindPlayer(attacker).getBlock().getLocation().add(0, 1, 0);
									if(isBlockNotSolid(b.getBlock())) {
										b.setDirection(attacker.getLocation().getDirection());
										b.setPitch(attacker.getLocation().getPitch());
										b.setYaw(attacker.getLocation().getYaw());
										p.teleport(b);
										p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
									}
								}
							}
					}
				}
				if(e.getEntity() instanceof Player && e.getDamager() instanceof Projectile) {
					Player p = (Player) e.getEntity();
					if(shopGUIS.enabled.get(p.getName()).contains(151)) {
					if(e.getDamager().hasMetadata("playershoot")) {
						if(e.getDamager().getMetadata("playershoot").size()>0) {
							Player attacker = Bukkit.getPlayer(e.getDamager().getMetadata("playershoot").get(0).asString());
							if(attacker != null) {
								if(attacker.getHealth()==attacker.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()) {
									Location b = getBlockBehindPlayer(attacker).getBlock().getLocation().add(0, 1, 0);
									if(isBlockNotSolid(b.getBlock())) {
										b.setDirection(attacker.getLocation().getDirection());
										b.setPitch(attacker.getLocation().getPitch());
										b.setYaw(attacker.getLocation().getYaw());
										p.teleport(b);
										p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
									}
								}
							}
						}
					}
					}
				}
			}
		}
		
		public static Location getBlockBehindPlayer(LivingEntity player) {
			Vector inverseDirectionVec = player.getLocation().getDirection().normalize().multiply(-1);
			return player.getLocation().add(inverseDirectionVec);
		}
			
		public void doSneakP(Player p) {
			if(shopGUIS.enabled.get(p.getName()).contains(137)) {
				//sneak off
				if(p.isSneaking()) {
					if(p.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
						p.removePotionEffect(PotionEffectType.INVISIBILITY);
						p.getWorld().playSound(p.getLocation(), Sound.ENTITY_BAT_TAKEOFF, 1, 1);
						p.getWorld().spawnParticle(Particle.SMOKE_NORMAL, p.getLocation().add(0, 1, 0), 20, 0.1, .5, 0.1, 0.01);
					}
				}
				//sneak on
				else {
					addPotionEffectBetter(p, PotionEffectType.INVISIBILITY, 999999, 0, false, false, false);
					p.getWorld().playSound(p.getLocation(), Sound.ENTITY_BAT_TAKEOFF, 1, 1);
					p.getWorld().spawnParticle(Particle.SMOKE_NORMAL, p.getLocation().add(0, 1, 0), 20, 0.1, .5, 0.1, 0.01);
				}
			}
			if(shopGUIS.enabled.get(p.getName()).contains(157)) {
				//sneak off
				if(p.isOnGround()) {
				if(!p.isSneaking()) {
					ItemStack itemStack = new ItemStack(Material.SPLASH_POTION);
					PotionMeta potionMeta = (PotionMeta) itemStack.getItemMeta();
					
					int amp = randor.nextInt(4);
					int duration = ((randor.nextInt(30)+1)*20);
					potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.values()[randor.nextInt(PotionEffectType.values().length)], duration, amp), true);
					potionMeta.setColor(colors.get(randor.nextInt(colors.size())));
					
					itemStack.setItemMeta(potionMeta);

					ThrownPotion thrownPotion = (ThrownPotion) p.getWorld().spawnEntity(p.getLocation().clone().add(0, 2.5, 0), EntityType.SPLASH_POTION);
					thrownPotion.setItem(itemStack);
				}
				}
			}
		}
		
		public void iterateRadio() {
			ArrayList<String> players = new ArrayList<String>(playertimes.keySet());
			for(String p : players) {
				Player pr = Bukkit.getPlayer(p);
				if(pr != null) {
				if(pr.isOnline()) {
				String disc = discs.get(pr);
				int secondcount = playertimes.get(p);
				Float pitch = pitches.get(pr);
				Sound discr = Sound.valueOf("MUSIC_DISC_" + disc.toUpperCase());
				double mult = pitch;
				if(mult < 0.5) {
					mult = 0.5;
				}
				if(secondcount >= (((double) discnames.get(disc))*(1.0/mult))) {
					playertimes.put(p, 0);
					for(String disctype : discnames.keySet()) {
						pr.stopSound(Sound.valueOf("MUSIC_DISC_" + disctype.toUpperCase()));
					}
					pr.playSound(pr.getLocation(), discr, 100, pitch);
				}
				else {
					playertimes.put(p, secondcount + 1);
				}
				}
				}
			}
		}
		
		public void fireWalk(Player p, Location l) {
			if(shopGUIS.enabled.get(p.getName()).contains(148)) {
				if(isBlockNotSolid(l.getBlock())) {
					l.getBlock().setType(Material.FIRE);
				}
			}
		}
		
		//
		
		//Sword Abilities
		
		HashMap<Player, Arrow> ability57 = new HashMap<Player, Arrow>();
		
		public void destroyEntity(Entity a) {
			for(Player pa : Bukkit.getServer().getOnlinePlayers()) {
				try {
				Object packet = getNmsClass("PacketPlayOutEntityDestroy").getConstructor(int[].class).newInstance(new int[] {a.getEntityId()});
		        sendPacket(pa, packet);
				}
				catch (Exception e) {
			        e.printStackTrace();
			    }
			}
		}
		
		public void swordEffectsF(){
			ArrayList<Player> ability57c = new ArrayList<Player>(ability57.keySet());
			for(Player p : ability57c) {
				Arrow a = ability57.get(p);
				if(canArrow(a)) {
					a.getWorld().spawnParticle(Particle.LAVA, a.getLocation(), 1, 0.4, 0.4, 0.4, 0.001);
					a.getWorld().spawnParticle(Particle.FLAME, a.getLocation(), 3, 0.3, 0.3, 0.3, 0.001);
					a.getWorld().spawnParticle(Particle.DRIP_LAVA, a.getLocation(), 1, 0.4, 0.4, 0.4, 0.001);
					a.getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, a.getLocation(), 1, 0, 0, 0, 0.001);
				}
				else {
					ability57.remove(p);
				}
			}
		}
		
		@EventHandler
		public void swordInteractEvent(PlayerInteractEvent e) {
			Player p = e.getPlayer();
			if(!notnpc(p)) {
				return;
			}
			if(!shopGUIS.enabled.containsKey(p.getName())) {
				return;
			}
			List<Integer> abilities = shopGUIS.enabled.get(e.getPlayer().getName());
			if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
				if(abilities.contains(57)) {
					if(!ability57.containsKey(p)) {
						Arrow a = p.launchProjectile(Arrow.class, p.getLocation().getDirection().normalize().multiply(.7));
						ability57.put(p, a);
						a.setMetadata("57", new FixedMetadataValue(this, 0));
						a.setMetadata(p.getName(), new FixedMetadataValue(this, 0));
						destroyEntity(a);
					}
				}
			}
		}
		
		@EventHandler
		public void arrowSwordHitEvent(ProjectileHitEvent e) {
			if(e.getEntity() instanceof Projectile) {
				Projectile a = (Projectile) e.getEntity();
				if(e.getHitBlock() != null) {
					if(a.hasMetadata("57")) {
						a.remove();
					}
				}
			}
		}
		
		//
		
		public void resetInventory(int abilitynum, Player p) {
			int index = abilitynum;
			PlayerInventory i = p.getInventory();
			Location l = p.getLocation();
			if(index == 91) {
			ItemStack bow = shopGUIS.makeItem(Material.BOW.name(), ChatColor.YELLOW + "Sleek Bow", Arrays.asList(ChatColor.GRAY + "A sleek wooden bow."), true);
			bow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 10);
			bow.addUnsafeEnchantment(Enchantment.DURABILITY, 200);
			ItemMeta itemmeta = bow.getItemMeta();
			itemmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			bow.setItemMeta(itemmeta);
			p.getWorld().dropItemNaturally(p.getLocation(), bow);
			}
				//swords
			else if(index == 56) {
					//p.getInventory().setItemInOffHand(new ItemStack(Material.SHIELD));
				}
			else if(index == 55) {
					ItemStack sword = shopGUIS.makeItem(Material.WOODEN_SWORD.name(), ChatColor.GRAY + "Wooden Sword", Arrays.asList(ChatColor.GRAY + "A dull wooden sword."), true);
					p.getWorld().dropItemNaturally(p.getLocation(), sword);
				}
				else if(index == 63) {
					ItemStack axe = shopGUIS.makeItem(Material.WOODEN_AXE.name(), ChatColor.GRAY + "Wooden Axe", Arrays.asList(ChatColor.GRAY + "A dull wooden axe."), true);
					p.getWorld().dropItemNaturally(p.getLocation(), axe);
				}
				else if(index ==64) {
					ItemStack sword = shopGUIS.makeItem(Material.IRON_SWORD.name(), ChatColor.WHITE + "Iron Sword", Arrays.asList(ChatColor.GRAY + "A sharp iron sword."), true);
					p.getWorld().dropItemNaturally(p.getLocation(), sword);
				}
				else if(index ==72) {
					ItemStack axe = shopGUIS.makeItem(Material.IRON_AXE.name(), ChatColor.WHITE + "Iron Axe", Arrays.asList(ChatColor.GRAY + "A sharp iron axe."), true);
					p.getWorld().dropItemNaturally(p.getLocation(), axe);
				}
				else if(index == 73) {
					ItemStack sword = shopGUIS.makeItem(Material.DIAMOND_SWORD.name(), ChatColor.AQUA + "Diamond Sword", Arrays.asList(ChatColor.GRAY + "The sharpest blade in", ChatColor.GRAY + "the land."), true);
					p.getWorld().dropItemNaturally(p.getLocation(), sword);
				}
				else if(index == 81) {
					ItemStack axe = shopGUIS.makeItem(Material.DIAMOND_AXE.name(), ChatColor.AQUA + "Diamond Axe", Arrays.asList(ChatColor.GRAY + "The sharpest axe in", ChatColor.GRAY + "the land."), true);
					p.getWorld().dropItemNaturally(p.getLocation(), axe);
				}
				else if(index == 47) {
					ItemStack carrot = shopGUIS.makeItem(Material.CARROT.name(), ChatColor.DARK_GREEN + "Infinite Carrot", Arrays.asList(ChatColor.GRAY + "Yummy carrot that never runs out."), false);
					p.getWorld().dropItemNaturally(p.getLocation(), carrot);
				}
				else if(index == 48) {
					ItemStack melon = shopGUIS.makeItem(Material.MELON_SLICE.name(), ChatColor.GREEN + "Infinite Melon", Arrays.asList(ChatColor.GRAY + "Yummy melon that never runs out."), false);
					p.getWorld().dropItemNaturally(p.getLocation(), melon);
				}
				else if(index == 49) {
					ItemStack rawbeef = shopGUIS.makeItem(Material.BEEF.name(), ChatColor.RED + "Infinite Beef", Arrays.asList(ChatColor.GRAY + "Yummy beef that never runs out."), false);
					p.getWorld().dropItemNaturally(p.getLocation(), rawbeef);
				}
				else if(index == 50) {
					ItemStack cfish = shopGUIS.makeItem(Material.COOKED_COD.name(), ChatColor.BLUE + "Infinite Fish", Arrays.asList(ChatColor.GRAY + "Yummy fish that never runs out."), false);
					p.getWorld().dropItemNaturally(p.getLocation(), cfish);
				}
				else if(index == 51) {
					ItemStack cbeef = shopGUIS.makeItem(Material.COOKED_BEEF.name(), ChatColor.DARK_RED + "Infinite Steak", Arrays.asList(ChatColor.GRAY + "Yummy steak that never runs out."), false);
					p.getWorld().dropItemNaturally(p.getLocation(), cbeef);
				}
				else if(index == 52) {
					ItemStack msoup = shopGUIS.makeItem(Material.MUSHROOM_STEW.name(), ChatColor.DARK_AQUA + "Infinite Soup", Arrays.asList(ChatColor.GRAY + "Yummy soup that never runs out."), false);
					p.getWorld().dropItemNaturally(p.getLocation(), msoup);
				}
				else if(index == 53) {
					ItemStack gapple = shopGUIS.makeItem(Material.GOLDEN_APPLE.name(), ChatColor.GOLD + "Infinite Life", Arrays.asList(ChatColor.GRAY + "Yummy golden apple that never runs out."), false);
					p.getWorld().dropItemNaturally(p.getLocation(), gapple);
				}
				else if(index == 1) {
					ItemStack lhel = shopGUIS.makeItem(Material.LEATHER_HELMET.name(), ChatColor.WHITE + "Leather Hat", Arrays.asList(ChatColor.GRAY + "A simple leather hat."), true);
					p.getWorld().dropItemNaturally(p.getLocation(), lhel);
				}
				else if(index == 2) {
					ItemStack lchest = shopGUIS.makeItem(Material.LEATHER_CHESTPLATE.name(), ChatColor.WHITE +"Leather Chestplate", Arrays.asList(ChatColor.GRAY + "A simple leather chestplate."), true);
					p.getWorld().dropItemNaturally(p.getLocation(), lchest);
				}
				else if(index == 3) {
					ItemStack lpant = shopGUIS.makeItem(Material.LEATHER_LEGGINGS.name(), ChatColor.WHITE +"Leather Leggings", Arrays.asList(ChatColor.GRAY + "Simple leather pants."), true);
					p.getWorld().dropItemNaturally(p.getLocation(), lpant);
				}
				else if(index == 4) {
					ItemStack lboot = shopGUIS.makeItem(Material.LEATHER_BOOTS.name(), ChatColor.WHITE +"Leather Boots", Arrays.asList(ChatColor.GRAY + "Simple leather shoes."), true);
					p.getWorld().dropItemNaturally(p.getLocation(), lboot);
				}
				else if(index == 10) {
					ItemStack lhel = shopGUIS.makeItem(Material.GOLDEN_HELMET.name(), ChatColor.YELLOW + "Golden Hat", Arrays.asList(ChatColor.GRAY + "Sparkly upgrade from the leather hat."), true);
					p.getWorld().dropItemNaturally(p.getLocation(), lhel);
				}
				else if(index == 11) {
					ItemStack lchest = shopGUIS.makeItem(Material.GOLDEN_CHESTPLATE.name(), ChatColor.YELLOW + "Gold Chestplate", Arrays.asList(ChatColor.GRAY + "Chestplate made from a whole" , ChatColor.GRAY + "20oz golden nugget."), true);
					p.getWorld().dropItemNaturally(p.getLocation(), lchest);
				}
				else if(index == 12) {
					ItemStack lpant = shopGUIS.makeItem(Material.GOLDEN_LEGGINGS.name(), ChatColor.YELLOW + "Golden Pants", Arrays.asList(ChatColor.GRAY + "Gold pants that make you look skinny."), true);
					p.getWorld().dropItemNaturally(p.getLocation(), lpant);
				}
				else if(index == 13) {
					ItemStack lboot = shopGUIS.makeItem(Material.GOLDEN_BOOTS.name(), ChatColor.YELLOW + "Gold Boots", Arrays.asList(ChatColor.GRAY + "Cute little golden shoes."), true);
					p.getWorld().dropItemNaturally(p.getLocation(), lboot);
				}
				else if(index == 19) {
					ItemStack lhel = shopGUIS.makeItem(Material.CHAINMAIL_HELMET.name(), ChatColor.DARK_GRAY + "Chainmail Hat", Arrays.asList(ChatColor.GRAY + "Strangely Efficient, even with", ChatColor.GRAY + "so many holes."), true);
					p.getWorld().dropItemNaturally(p.getLocation(), lhel);
				}
				else if(index == 20) {
					ItemStack lchest = shopGUIS.makeItem(Material.CHAINMAIL_CHESTPLATE.name(), ChatColor.DARK_GRAY + "Chainmail Chestplate", Arrays.asList(ChatColor.GRAY + "Chainy Chestplate."), true);
					p.getWorld().dropItemNaturally(p.getLocation(), lchest);
				}
				else if(index == 21) {
					ItemStack lpant = shopGUIS.makeItem(Material.CHAINMAIL_LEGGINGS.name(), ChatColor.DARK_GRAY + "Chainmail Pants", Arrays.asList(ChatColor.GRAY + "Not recommended for sneaking."), true);
					p.getWorld().dropItemNaturally(p.getLocation(), lpant);
				}
				else if(index == 22) {
					ItemStack lboot = shopGUIS.makeItem(Material.CHAINMAIL_BOOTS.name(), ChatColor.DARK_GRAY + "Chainmail Boots", Arrays.asList(ChatColor.GRAY + "Not water-proof."), true);
					p.getWorld().dropItemNaturally(p.getLocation(), lboot);
				}
				else if(index == 28) {
					ItemStack lhel = shopGUIS.makeItem(Material.IRON_HELMET.name(), ChatColor.GRAY + "Iron Hat", Arrays.asList(ChatColor.GRAY + "Hat made from an iron fence."), true);
					p.getWorld().dropItemNaturally(p.getLocation(), lhel);
				}
				else if(index == 29) {
					ItemStack lchest = shopGUIS.makeItem(Material.IRON_CHESTPLATE.name(), ChatColor.GRAY + "Iron Chestplate", Arrays.asList(ChatColor.GRAY + "How do you even move in here?"), true);
					p.getWorld().dropItemNaturally(p.getLocation(), lchest);
				}
				else if(index == 30) {
					ItemStack lpant = shopGUIS.makeItem(Material.IRON_LEGGINGS.name(), ChatColor.GRAY + "Iron Pants", Arrays.asList(ChatColor.GRAY + "Really heavy but oh well."), true);
					p.getWorld().dropItemNaturally(p.getLocation(), lpant);
				}
				else if(index == 31) {
					ItemStack lboot = shopGUIS.makeItem(Material.IRON_BOOTS.name(), ChatColor.GRAY + "Iron Boots", Arrays.asList(ChatColor.GRAY + "Really waterproof."), true);
					p.getWorld().dropItemNaturally(p.getLocation(), lboot);
				}
				else if(index == 37) {
					ItemStack lhel = shopGUIS.makeItem(Material.DIAMOND_HELMET.name(), ChatColor.AQUA + "Diamond Hat", Arrays.asList(ChatColor.GRAY + "Cute aqua hat for not dying."), true);
					p.getWorld().dropItemNaturally(p.getLocation(), lhel);
				}
				else if(index == 38) {
					ItemStack lchest = shopGUIS.makeItem(Material.DIAMOND_CHESTPLATE.name(), ChatColor.AQUA + "Diamond Chestplate", Arrays.asList(ChatColor.GRAY + "OoOooOo, sparkly."), true);
					p.getWorld().dropItemNaturally(p.getLocation(), lchest);
				}
				else if(index == 39) {
					ItemStack lpant = shopGUIS.makeItem(Material.DIAMOND_LEGGINGS.name(), ChatColor.AQUA + "Diamond Pants", Arrays.asList(ChatColor.GRAY + "Best pants in the country."), true);
					p.getWorld().dropItemNaturally(p.getLocation(), lpant);
				}
				else if(index == 40) {
					ItemStack lboot = shopGUIS.makeItem(Material.DIAMOND_BOOTS.name(), ChatColor.AQUA + "Diamond Boots", Arrays.asList(ChatColor.GRAY + "Also waterproof."), true);
					p.getWorld().dropItemNaturally(p.getLocation(),lboot);
				}
				else if(index == 5) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 0, false, false, false));
				}
				else if(index == 42) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 0, false, false, false));
					addPotionEffectBetter(p, PotionEffectType.SPEED, 999999, 0, false, false, false);
					addPotionEffectBetter(p, PotionEffectType.HEALTH_BOOST, 999999, 1, false, false, false);
					addPotionEffectBetter(p, PotionEffectType.NIGHT_VISION, 999999, 0, false, false, false);
				}
				else if(index == 138) {
					ItemStack lchest = shopGUIS.makeItem(Material.ELYTRA.name(), ChatColor.YELLOW + "Wings of The Nephilim", Arrays.asList(ChatColor.GRAY + "Stolen but useful."), true);
					p.getWorld().dropItemNaturally(p.getLocation(), lchest);
				}
		}
	
		//
		
		/*@EventHandler
		public void breakb(BlockBreakEvent e) {
			if(inSpawnRegion(e.getBlock().getLocation())) {
				e.setCancelled(true);
			}
		}
		
		@EventHandler
		public void placep(BlockPlaceEvent e) {
			if(inSpawnRegion(e.getBlock().getLocation())) {
				e.setCancelled(true);
			}
		}*/
		
		public boolean notnpc(Entity e) {
			if(e instanceof Player) {
				if(Bukkit.getOnlinePlayers().contains(((Player) e))) {
					return true;
				}
			}
			return false;
		}
		
		 //fast water
		
		public void passiveJoin(Player p, List<Integer> abilities) {
			if(abilities.contains(188)) {
				if(!playerInWater.containsKey(p)) {
				playerInWater.put(p, 0.1);
				}
			}
			if(abilities.contains(181)) {
				if(!torch.containsKey(p)) {
				torch.put(p, null);
				}
			}
			if(abilities.contains(187)) {
				if(!darkregen.contains(p)) {
					darkregen.add(p);
				}
			}
			if(abilities.contains(186)) {
				if(!darkregenF.contains(p)) {
					darkregenF.add(p);
				}
			}
			if(abilities.contains(185)) {
				if(!lightregen.contains(p)) {
					lightregen.add(p);
				}
			}
			if(abilities.contains(184)) {
				if(!lightregenF.contains(p)) {
					lightregenF.add(p);
				}
			}
			if(abilities.contains(183)) {
				if(!waterregen.contains(p)) {
					waterregen.add(p);
				}
			}
			if(abilities.contains(182)) {
				if(!waterregenF.contains(p)) {
					waterregenF.add(p);
				}
			}
		}
		
		public void passiveEnable(Player p, int ability) {
			if(ability == 188) {
				if(!playerInWater.containsKey(p)) {
				playerInWater.put(p, 0.1);
				}
			}
			if(ability == 181) {
				if(!torch.containsKey(p)) {
				torch.put(p, null);
				}
			}
			if(ability == 187) {
				if(!darkregen.contains(p)) {
					darkregen.add(p);
				}
			}
			if(ability == 186) {
				if(!darkregenF.contains(p)) {
					darkregenF.add(p);
				}
			}
			if(ability == 185) {
				if(!lightregen.contains(p)) {
					lightregen.add(p);
				}
			}
			if(ability == 184) {
				if(!lightregenF.contains(p)) {
					lightregenF.add(p);
				}
			}
			if(ability == 183) {
				if(!waterregen.contains(p)) {
					waterregen.add(p);
				}
			}
			if(ability == 182) {
				if(!waterregenF.contains(p)) {
					waterregenF.add(p);
				}
			}
		}
		
		public void passiveDisable(Player p, int ability) {
			if(ability == 188) {
				if(playerInWater.containsKey(p)) {
				playerInWater.remove(p);
				}
			}
			if(ability == 181) {
				if(torch.containsKey(p)) {
				torch.remove(p);
				}
			}
			if(ability == 187) {
				if(darkregen.contains(p)) {
					darkregen.remove(p);
				}
			}
			if(ability == 186) {
				if(darkregenF.contains(p)) {
					darkregenF.remove(p);
				}
			}
			if(ability == 185) {
				if(lightregen.contains(p)) {
					lightregen.remove(p);
				}
			}
			if(ability == 184) {
				if(lightregenF.contains(p)) {
					lightregenF.remove(p);
				}
			}
			if(ability == 183) {
				if(waterregen.contains(p)) {
					waterregen.remove(p);
				}
			}
			if(ability == 182) {
				if(waterregenF.contains(p)) {
					waterregenF.remove(p);
				}
			}
		}
	
		HashMap<Player, Double> playerInWater = new HashMap<Player, Double>();
	
		public void increaseWaterVelocity() {
		HashMap<Player, Double> playerInWaterCopy = new HashMap<Player, Double>(playerInWater);
		for(Player p : playerInWaterCopy.keySet()) {
			boolean didSomething = false;
			if(canHuman(p)) {
				if(!shopGUIS.enabled.get(p.getName()).contains(188)) {
					playerInWater.remove(p);
				}
				else{
				boolean water = false;
				boolean sneaking = p.isSneaking();
				Block b = p.getLocation().getBlock();
				boolean isWater = false;
				if(b.getBlockData() instanceof Waterlogged) {
					isWater = ((Waterlogged) b.getBlockData()).isWaterlogged();
				}
				if(b.getType() == Material.WATER || b.getType() == Material.KELP_PLANT || b.getType() == Material.SEAGRASS || b.getType() == Material.TALL_SEAGRASS || isWater) {
					water = true;
				}
				if(sneaking && water) {
					double mult = playerInWaterCopy.get(p);
					if(mult < 1.35) {
						mult += .015;
					}
					Vector v = p.getLocation().getDirection().normalize().multiply(mult);
					p.setVelocity(v);
					playerInWater.put(p, mult);
				}
				else if(water || sneaking) {
					if(!p.isGliding()) {
					double mult = playerInWaterCopy.get(p) - .03;
					if(mult <= 0.1) {
						playerInWater.put(p, 0.1);
					}
					else {
					playerInWater.put(p, mult);
					}
					}
					else {
						double mult = playerInWaterCopy.get(p) - .005;
						if(mult <= 0.1) {
							playerInWater.put(p, 0.1);
						}
						else {
						playerInWater.put(p, mult);
						}
					}
				}
				}
			}
			else{
				playerInWater.remove(p);
			}
		}
	}
	
		@EventHandler
		public void onSneakInWater(PlayerToggleSneakEvent e) {
		Player p = e.getPlayer();
		if(!p.isSneaking()) {
				Location l = p.getLocation().clone();
				if(l.getBlock().getType() == Material.WATER) {
					if(!playerInWater.containsKey(p)) {
					playerInWater.put(p, 0.1);
					}
				}
			}
		}
	
	//mining ability
	
	@EventHandler
	public void mineStone(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(shopGUIS.enabled.get(e.getPlayer().getName()).contains(172)) {
		ItemStack hand = p.getInventory().getItemInMainHand();
		if(hand != null) {
			if(hand.getType().name().toLowerCase().contains("pickaxe")) {
			if(e.getBlock() != null) {
				if(isStony(e.getBlock().getType())) {
					if(!e.isCancelled()) {
					BlockFace[] faces = {BlockFace.UP, BlockFace.DOWN, BlockFace.EAST, BlockFace.WEST, BlockFace.NORTH, BlockFace.SOUTH};
					for(BlockFace bf : faces) {
						if(isStony(e.getBlock().getRelative(bf).getType())) {
							e.getBlock().getRelative(bf).breakNaturally(hand);
						}
					}
				}
				}
			}
			}
		}
		}
		if(shopGUIS.enabled.get(e.getPlayer().getName()).contains(171)) {
			ItemStack hand = p.getInventory().getItemInMainHand();
			if(hand != null) {
				if(hand.getType().name().toLowerCase().contains("pickaxe")) {
				if(e.getBlock() != null) {
					if(e.getBlock().getType().name().toLowerCase().contains("ore")) {
						Material m = e.getBlock().getType();
						if(m == Material.IRON_ORE || m == Material.GOLD_ORE) {
							e.setCancelled(true);
							e.getBlock().setType(Material.AIR);
							e.getBlock().getWorld().dropItem(e.getBlock().getLocation().add(0.5, 0, 0.5), new ItemStack(Material.getMaterial(m.name().substring(0, 5)+"INGOT")));
						}
					}
				}
				}
			}
		}
	}
	
	//axe ability
	
	@EventHandler
	public void mineWood(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(shopGUIS.enabled.get(e.getPlayer().getName()).contains(170)) {
		ItemStack hand = p.getInventory().getItemInMainHand();
		if(hand != null) {
			if(hand.getType().name().toLowerCase().contains("axe")) {
			if(e.getBlock() != null) {
				if(e.getBlock().getType().name().toLowerCase().contains("log") || e.getBlock().getType().name().toLowerCase().contains("leave")) {
					if(!e.isCancelled()) {
					BlockFace[] faces = {BlockFace.UP, BlockFace.DOWN, BlockFace.EAST, BlockFace.WEST, BlockFace.NORTH, BlockFace.SOUTH};
					for(BlockFace bf : faces) {
						if(e.getBlock().getRelative(bf).getType().name().toLowerCase().contains("leave")||e.getBlock().getRelative(bf).getType().name().toLowerCase().contains("log")) {
							e.getBlock().getRelative(bf).breakNaturally(hand);
						}
					}
				}
				}
			}
			}
		}
		}
	}
	
	//Situational Regen
	
	List<Player> darkregen = new ArrayList<Player>();
	List<Player> lightregen = new ArrayList<Player>();
	List<Player> waterregen = new ArrayList<Player>();
	
	List<Player> darkregenF = new ArrayList<Player>();
	List<Player> lightregenF = new ArrayList<Player>();
	List<Player> waterregenF = new ArrayList<Player>();
	
	public void regenPlayers() {
		List<Player> darkregenC = new ArrayList<Player>(darkregen);
		List<Player> lightregenC = new ArrayList<Player>(lightregen);
		List<Player> waterregenC = new ArrayList<Player>(waterregen);
		for(Player p : darkregenC) {
			if(canHuman(p)) {
				if(p.getHealth() < p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()) {
				if(p.getLocation().getBlock().getLightLevel() <= 4) {
					int light = p.getLocation().getBlock().getLightLevel()+1;
					double ammount = ((light * 2) / (light * light)) * 2;
					healPlayer(p, ammount);
					p.getWorld().spawnParticle(Particle.SQUID_INK, p.getLocation().add(0, 1, 0), 2, 0.35, 0.5, 0.35, 0.001);
				}
				}
			}
			else {
				darkregen.remove(p);
			}
		}
		for(Player p : lightregenC) {
			if(canHuman(p)) {
				if(p.getHealth() < p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()) {
				if(p.getLocation().getBlock().getLightLevel() >= 12) {
					int light = p.getLocation().getBlock().getLightLevel();
					double ammount = 16 - light;
					healPlayer(p, ammount);
					p.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, p.getLocation().add(0, 1, 0), 2, 0.35, 0.5, 0.35, 0.001);
				}
				}
			}
			else {
				lightregen.remove(p);
			}
		}
		for(Player p : waterregenC) {
			if(canHuman(p)) {
				if(p.getHealth() < p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()) {
				Block b = p.getLocation().getBlock();
				boolean isWater = false;
				if(b.getBlockData() instanceof Waterlogged) {
					isWater = ((Waterlogged) b.getBlockData()).isWaterlogged();
				}
				if(b.getType() == Material.WATER || b.getType() == Material.KELP_PLANT || b.getType() == Material.SEAGRASS || b.getType() == Material.TALL_SEAGRASS || isWater) {
					isWater = true;
				}
				if(isWater) {
					healPlayer(p, 2);
					p.playSound(p.getLocation(), Sound.ITEM_BOTTLE_FILL, 1, (float) 1.1);
				}
				}
			}
			else {
				waterregen.remove(p);
			}
		}
		List<Player> darkregenCF = new ArrayList<Player>(darkregenF);
		List<Player> lightregenCF = new ArrayList<Player>(lightregenF);
		List<Player> waterregenCF = new ArrayList<Player>(waterregenF);
		for(Player p : darkregenCF) {
			if(canHuman(p)) {
				if(p.getFoodLevel() < 20) {
				if(p.getLocation().getBlock().getLightLevel() <= 4) {
					int light = p.getLocation().getBlock().getLightLevel()+1;
					double ammount = ((light * 2) / (light * light)) * 2;
					feedPlayer(p, ammount);
					p.getWorld().spawnParticle(Particle.SQUID_INK, p.getLocation().add(0, 1, 0), 2, 0.35, 0.5, 0.35, 0.001);
					p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EAT, 1, (float) 1.1);
				}
				}
			}
			else {
				darkregenF.remove(p);
			}
		}
		for(Player p : lightregenCF) {
			if(canHuman(p)) {
				if(p.getFoodLevel() < 20) {
				if(p.getLocation().getBlock().getLightLevel() >= 12) {
					int light = p.getLocation().getBlock().getLightLevel();
					double ammount = 16 - light;
					feedPlayer(p, ammount);
					p.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, p.getLocation().add(0, 1, 0), 2, 0.35, 0.5, 0.35, 0.001);
					p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EAT, 1, (float) 1.1);
				}
				}
			}
			else {
				lightregenF.remove(p);
			}
		}
		for(Player p : waterregenCF) {
			if(canHuman(p)) {
				if(p.getFoodLevel() < 20) {
				Block b = p.getLocation().getBlock();
				boolean isWater = false;
				if(b.getBlockData() instanceof Waterlogged) {
					isWater = ((Waterlogged) b.getBlockData()).isWaterlogged();
				}
				if(b.getType() == Material.WATER || b.getType() == Material.KELP_PLANT || b.getType() == Material.SEAGRASS || b.getType() == Material.TALL_SEAGRASS || isWater) {
					isWater = true;
				}
				if(isWater) {
					feedPlayer(p, 2);
					p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_DRINK, 1, (float) 1.1);
				}
				}
			}
			else {
				waterregenF.remove(p);
			}
		}
	}

	//Passive Lights
	
	HashMap<Player, Block> torch = new HashMap<Player, Block>();
	
	public void makeFireLine(Player p, Location to, Location from) {
		Location start = to.clone().getBlock().getLocation().add(0.5, 0.5, 0.5);
		Location end = from.clone().getBlock().getLocation().add(0.5, 0.5, 0.5);
		double step = 0.1D;

		Vector line = end.toVector().subtract(start.toVector());
		if(line.length() > 8) {
			p.spawnParticle(Particle.FLAME, start.clone(), 20, .2, .2, .2, 0.01);
			return;
		}
		for (double d = 0; d < line.length()/4.0; d += step) {
			final double dd = d;
			p.spawnParticle(Particle.FLAME, start.clone().add(line.clone().multiply(dd)), 3, 0, 0, 0, 0.001);
		}
	}

	@EventHandler
	public void onPlayerLightMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
			if(torch.containsKey(p)) {
			Location from = e.getTo().clone();
			Location to = e.getFrom().clone();
			if(differentBlock(to, from)) {
				boolean doTorch = false;
				if(torch.get(p) == null) {
					doTorch = true;
				}
				else {
					Location cloneTo = to.clone().add(0, 2, 0);
					if(cloneTo.distance(torch.get(p).getLocation())>=5) {
						doTorch = true;
					}
				}
				if(doTorch) {
				if(torch.get(p) != null) {
					p.sendBlockChange(torch.get(p).getLocation(), torch.get(p).getBlockData());
				}
				if(to.getBlock().getLightLevel()<8 || (isNight(to.getWorld())&&to.getBlock().getLightFromSky() > 7)) {
				to.add(0, 2, 0);
				if(isAir(to.getBlock().getType())) {
					if(torch.get(p)!=null) {
						makeFireLine(p, to, torch.get(p).getLocation());
					}
					else {
						p.spawnParticle(Particle.FLAME, to.clone().getBlock().getLocation().add(0.5, 0.5, 0.5), 20, .2, .2, .2, 0.01);
					}
					torch.put(p, to.getBlock());
					p.sendBlockChange(to.getBlock().getLocation(), Material.LANTERN.createBlockData());
				}
				}
				else {
					if(torch.get(p) != null) {
						torch.put(p, null);
					}
				}
				}
			}
		}
	}

	//Grappling Hook
	
	public void pushToGrapple(int iteration, Location target, Player p, int maxIteration) {
		if(p.isSneaking() || maxIteration >= 500 || iteration >= maxIteration || target.getWorld().getNearbyEntities(target, .5, .5, .5).contains(p)) {
			return;
		}
		else {
			Vector v = target.toVector().subtract(p.getLocation().toVector()).normalize();
			p.setVelocity(v);
			Bukkit.getScheduler().runTaskLater(this, () -> pushToGrapple(iteration + 1, target, p, maxIteration), (long) (1));
		}
	}
	
	@EventHandler
	public void grapplingHookStuck(PlayerFishEvent e) {
		Player p = e.getPlayer();
		if(!shopGUIS.enabled.containsKey(p.getName())) {
			return;
		}
		if(shopGUIS.enabled.get(e.getPlayer().getName()).contains(169)) {
			if(e.getState() == State.IN_GROUND) {
				pushToGrapple(0, e.getHook().getLocation(), p, (int) (p.getLocation().distance(e.getHook().getLocation())*5));
			}
		}
	}
	
	//Dimensional Doors

	HashMap<Player, Location> doorsaves = new HashMap<Player, Location>();
	HashMap<Block, Integer> doors = new HashMap<Block, Integer>();
	HashMap<Block, Player> doorsend = new HashMap<Block, Player>();
	
	@EventHandler
	public void playerSavesLocation(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(!shopGUIS.enabled.containsKey(p.getName())) {
			return;
		}
		if(shopGUIS.enabled.get(e.getPlayer().getName()).contains(168)) {
			if(p.isSneaking()&&(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
				p.getWorld().playSound(p.getLocation(), Sound.ITEM_FIRECHARGE_USE, 1, 1);
				float radius = 1.0f;
				Location location = p.getLocation().clone().add(0, 1, 0);
				for(float angle = 0f; angle < 6.4; angle += 0.1) {
				double x = (radius * Math.sin(angle));
				double z = (radius * Math.cos(angle));
				location.getWorld().spawnParticle(Particle.SMOKE_NORMAL, location.getX()+x, location.getY(), location.getZ()+z, 1, 0, 0, 0, 0.0001);
				}
				p.getWorld().spawnParticle(Particle.SQUID_INK, p.getLocation().add(0, 1, 0), 10, 0.2, 0.2, 0.2, 0.0001);
				doorsaves.put(p, p.getLocation().clone().add(0, 0.05, 0));
			}
		}
	}
	
	@EventHandler
	public void playerReachesDoor(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if(!notnpc(p)) {
			return;
		}
		if(p.isSneaking()) {
			if(!shopGUIS.enabled.containsKey(p.getName())) {
				return;
			}
			if(shopGUIS.enabled.get(e.getPlayer().getName()).contains(168)) {
				if(doorsaves.containsKey(p)) {
					if(p.getLocation().getBlock().getType().name().toLowerCase().contains("door")) {
						doors.put(p.getLocation().getBlock(), 0);
						doorsend.put(p.getLocation().getBlock(), p);
						addPotionEffectBetter(p, PotionEffectType.INVISIBILITY, 25, 1, false, false, false);
						addPotionEffectBetter(p, PotionEffectType.BLINDNESS, 25, 1, false, false, false);
						p.teleport(doorsaves.get(p));
					}
				}
			}
		}
	}
	
	public void activateDoor() {
		List<Block> doorsCopy = new ArrayList<Block>(doors.keySet());
		for(Block b : doorsCopy) {
			if(b != null) {
				int time = doors.get(b) + 1;
				if(time >= 200 || (!(b.getType().name().toLowerCase().contains("door")))) {
					doors.remove(b);
					doorsend.remove(b);
				}
				else {
					if(!((Openable) b.getBlockData()).isOpen()) {
					for(Entity e : b.getWorld().getNearbyEntities(b.getLocation().add(0.5, 0, 0.5), .1, .1, .1)) {
						if(e instanceof LivingEntity) {
							addPotionEffectBetter(((LivingEntity) e), PotionEffectType.INVISIBILITY, 25, 1, false, false, false);
							addPotionEffectBetter(((LivingEntity) e), PotionEffectType.BLINDNESS, 25, 1, false, false, false);
						}
						e.teleport(doorsaves.get(doorsend.get(b)));
					}
					}
					else {
						BlockFace facing = ((Directional) b.getBlockData()).getFacing();
						if(facing == BlockFace.WEST) {
							b.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, b.getLocation().add(0.7, .9, 0.5), 4, 0, 0.45, 0.13, 0.0001);
						}
						else if(facing == BlockFace.EAST) {
							b.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, b.getLocation().add(0.3, .9, 0.5), 4, 0, 0.45, 0.13, 0.0001);
						}
						if(facing == BlockFace.SOUTH) {
							b.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, b.getLocation().add(0.5, .9, 0.3), 4, 0.13, 0.45, 0, 0.0001);
						}
						if(facing == BlockFace.NORTH) {
							b.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, b.getLocation().add(0.5, .9, 0.7), 4, 0.13, 0.45, 0, 0.0001);
						}
					}
					doors.put(b, time);
				}
			}
			else {
				doors.remove(b);
				doorsend.remove(b);
			}
		}
	}
		
}
