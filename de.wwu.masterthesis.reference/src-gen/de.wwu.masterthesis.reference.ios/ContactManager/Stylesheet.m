//
//  Stylesheet.m
//
//  Generated by MD2 framework on Fri Jul 05 12:05:30 CEST 2013.
//  Copyright (c) 2012 Uni-Muenster. All rights reserved.
//

#import "Md2Library/Stylesheet.h"
#import "DefaultStyle.h"

@implementation Stylesheet

@synthesize identifier, font, textColor;

+(id) style
{
	return [[[self class] alloc] init];
}

-(id) init
{
	self = [super init];
	if (self)
	{
		// Default values, as specified in UIKit's documentation
		self.font = [UIFont systemFontOfSize: 17.0];
		self.textColor = [UIColor blackColor];
	}
	return self;
}

-(void) applyToObject: (id) object idenfier: (NSString *) _identifier
{
	if ([object respondsToSelector: @selector(setFont:)])
	{
			[object setFont: DefaultFont];
	}
	
	if ([object respondsToSelector: @selector(setTextColor:)])
	{
			[object setTextColor: DefaultTextColor];
	}
}

-(void) applyToObject: (id) object
{
	if ([object respondsToSelector: @selector(setFont:)])
	{
		[object setFont: self.font];
	}
	if ([object respondsToSelector: @selector(setTextColor:)])
	{
		[object setTextColor: self.textColor];
	}
}

@end