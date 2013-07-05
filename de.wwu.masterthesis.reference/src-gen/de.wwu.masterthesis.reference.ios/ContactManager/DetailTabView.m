//
//  DetailTabView.m
//
//  Generated by MD2 framework on Fri Jul 05 12:05:29 CEST 2013.
//  Copyright (c) 2012 Uni-Muenster. All rights reserved.
//

#import "DetailTabView.h"
#import "Md2Library/FlowLayout.h"

@implementation DetailTabView

-(id) init
{
	self = [super init];
	if (self)
		identifier = @"detailTab";
	return self;
}

-(void) loadView
{
	[super loadView];
	
	defaultLayout = [[FlowLayout alloc] initWithFrame: LayoutFrame(self.frame) numberElements: 12 direction: Vertical identifier: @"detailTabDefaultLayout"];
	
	[self addWidget: [self createTextFieldWidget: @"photoTextInput" hasInfoButton: NO]];
	[self addWidget: [self createTextFieldWidget: @"nameTextInput1" hasInfoButton: NO]];
	[self addWidget: [self createTextFieldWidget: @"firstnameTextInput" hasInfoButton: NO]];
	[self addWidget: [self createTextFieldWidget: @"phoneTextInput" hasInfoButton: NO]];
	[self addWidget: [self createTextFieldWidget: @"emailTextInput" hasInfoButton: NO]];
	[self addWidget: [self createTextFieldWidget: @"streetTextInput" hasInfoButton: NO]];
	[self addWidget: [self createTextFieldWidget: @"cityTextInput" hasInfoButton: NO]];
	[self addWidget: [self createTextFieldWidget: @"zipCodeTextInput" hasInfoButton: NO]];
	[self addWidget: [self createButtonWidget: @"retrieveGPS"]];
	[self addWidget: [self createLabelWidget: @"groupLabel" hasInfoButton: NO]];
	[self addWidget: [self createButtonWidget: @"addGroupButton"]];
	
	FlowLayout *persistence1Layout = [[FlowLayout alloc] initWithFrame: LayoutFrame(self.frame) numberElements: 1 direction: Horizontal identifier: @"persistence1Layout"];
	[self addWidget: [self createButtonWidget: @"saveButton1"] toLayout: persistence1Layout];
	[self addView: persistence1Layout identifier: @"persistence1Layout"];
	
	
	[contentView addSubview: defaultLayout];
}

@end